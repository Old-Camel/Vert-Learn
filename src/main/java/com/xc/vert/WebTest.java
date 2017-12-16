package com.xc.vert;

import com.xc.vert.util.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TODO:TODO
 * Auther:徐成
 * Date:2017/12/14
 * Email:old_camel@126.com
 */
public class WebTest extends AbstractVerticle {
    public static void main(String[] args) {
        Runner.runExample(WebTest.class);
    }
    @Override
    public void start(Future<Void> fut) throws Exception {
        createSomeData();
        Router router = Router.router(vertx);
        router.route("/api/user*").handler(BodyHandler.create());
        router.post("/api/user").handler(this::addOne);
        router.get("/api/user").handler(this::getAll);
        vertx.createHttpServer().requestHandler(router::accept)
                .listen(
                        // Retrieve the port from the configuration,
                        // default to 8080.
                        config().getInteger("http.port", 8080),
                        result -> {
                            if (result.succeeded()) {
                                fut.complete();
                            } else {
                                fut.fail(result.cause());
                            }
                        }
                );
    }
    private Map<Integer, User> products = new LinkedHashMap<>();
    // Create some product
// 创建一些产品
    private void createSomeData() {
        User user1 = new User("徐成", 18);
        products.put(user1.getId(), user1);
        User user2 = new User("小红", 18);
        products.put(user2.getId(), user2);
    }
    private void getAll(RoutingContext routingContext) {
        routingContext.response()
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encodePrettily(products.values()));
                //.end("11231");
    }
    private void addOne(RoutingContext routingContext) {
        System.out.println(routingContext.getBodyAsString());
        final User user = Json.decodeValue(routingContext.getBodyAsString(),
                User.class);
        products.put(user.getId(), user);
        routingContext.response()
                .setStatusCode(201)
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encodePrettily(user));


    }


}
