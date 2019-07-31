package com.techempower

import io.vertx.core.json.JsonObject
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.core.http.listenAwait
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.dispatcher
import io.vertx.kotlin.sqlclient.preparedQueryAwait
import io.vertx.pgclient.PgConnectOptions
import io.vertx.pgclient.PgPool
import io.vertx.sqlclient.PoolOptions
import io.vertx.sqlclient.SqlClient
import io.vertx.sqlclient.Tuple
import kotlinx.coroutines.launch

class MainVerticle : CoroutineVerticle() {

    private lateinit var client: SqlClient

    companion object {
        private const val SELECT_WORLD = "SELECT id from world where id=$1"
    }

    override suspend fun start() {
        val connectOptions = PgConnectOptions()
        connectOptions.database = "techempower-test"
        connectOptions.host = "127.0.0.1"
        connectOptions.port = 5432
        connectOptions.user = "postgres"
        connectOptions.password = "postgres"
        connectOptions.cachePreparedStatements = true
        client = PgPool.pool(vertx, connectOptions, PoolOptions())
        val router = Router.router(vertx)
        router.get("/").coroutineHandler(this::handler)
        vertx.createHttpServer()
                .requestHandler(router)
                .listenAwait(8089)
    }

    private suspend fun handler(rc: RoutingContext) {
        val resp = rc.response()
        val rowSet = client.preparedQueryAwait(SELECT_WORLD, Tuple.of(1))
        resp.end(JsonObject().put("id", rowSet.iterator().next().getInteger(0)).toString())
    }

    /**
     * An extension method for simplifying coroutines usage with Vert.x Web routers
     */
    private fun Route.coroutineHandler(fn: suspend (RoutingContext) -> Unit) {
        handler { ctx ->
            launch(ctx.vertx().dispatcher()) {
                try {
                    fn(ctx)
                } catch (e: Exception) {
                    ctx.fail(e)
                }
            }
        }
    }
}
