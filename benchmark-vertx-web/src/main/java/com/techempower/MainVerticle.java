package com.techempower;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.SqlClient;
import io.vertx.sqlclient.Tuple;

/**
 * MainVerticle
 */
public class MainVerticle extends AbstractVerticle {

    private SqlClient client;
    private HttpServer server;
    private static String SELECT_WORLD = "SELECT id from world where id=$1";

    @Override
    public void start() throws Exception {
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
        server = vertx.createHttpServer().requestHandler(router).listen(8089);
    }

    @Override
    public void stop() {
        if (server != null)
            server.close();
    }

    public void handle(RoutingContext rc) {
        HttpServerResponse resp = rc.response();
        client.preparedQuery(SELECT_WORLD, Tuple.of(1), ar -> {
            if (ar.succeeded()) {
                final Tuple row = ar.result().iterator().next();
                resp.end(new JsonObject().put("id", row.getInteger(0)).toString());
            } else {
                resp.end(new JsonObject().put("error", ar.cause().getMessage()).toString());
            }
        });
    }
}
