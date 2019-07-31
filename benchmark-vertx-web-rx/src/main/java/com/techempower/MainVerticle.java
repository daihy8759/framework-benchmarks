package com.techempower;

import io.reactivex.Completable;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.http.HttpServerResponse;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.RoutingContext;
import io.vertx.reactivex.pgclient.PgPool;
import io.vertx.reactivex.sqlclient.SqlClient;
import io.vertx.reactivex.sqlclient.Tuple;
import io.vertx.sqlclient.PoolOptions;

/**
 * MainVerticle
 */
public class MainVerticle extends AbstractVerticle {

    private SqlClient client;
    private static String SELECT_WORLD = "SELECT id from world where id=$1";

    @Override
    public Completable rxStart() {
        PgConnectOptions connectOptions = new PgConnectOptions();
        connectOptions.setDatabase("techempower-test");
        connectOptions.setHost("127.0.0.1");
        connectOptions.setPort(5432);
        connectOptions.setUser("postgres");
        connectOptions.setPassword("postgres");
        connectOptions.setCachePreparedStatements(true);
        client = PgPool.pool(vertx, connectOptions, new PoolOptions());
        Router router = Router.router(vertx);
        router.get("/").handler(rc -> {
            this.handle(rc);
        });
        return vertx.createHttpServer().requestHandler(router).rxListen(8089).ignoreElement();
    }

    public void handle(RoutingContext rc) {
        HttpServerResponse resp = rc.response();
        client.rxPreparedQuery(SELECT_WORLD, Tuple.of(1)).subscribe(rowSet -> {
            final Tuple row = rowSet.iterator().next();
            resp.end(new JsonObject().put("id", row.getInteger(0)).toString());
        });
    }
}
