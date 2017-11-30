package com.yunzainfo.pitcher.pushserver;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

public class Sockjs
{
    public static void main(String[] args)
    {
   Vertx vertx=Vertx.vertx();
             HttpServer server = vertx.createHttpServer();

        server.requestHandler(request -> {

            // This handler gets called for each request that arrives on the server
            HttpServerResponse response = request.response();
            response.putHeader("content-type", "text/html;charset=utf-8");

            // Write to the response and end it
            response.end("徐");
        });

        server.listen(8080);
        //HttpServer server = vertx.createHttpServer();
        //
        //Router router = Router.router(vertx);
        //
        //router.route().handler(routingContext -> {
        //
        //    // This handler will be called for every request
        //    HttpServerResponse response = routingContext.response();
        //    response.putHeader("content-type", "text/plain");
        //
        //    // Write to the response and end it
        //    response.end("Hello World from Vert.x-Web!");
        //});
        //
        //server.requestHandler(router::accept).listen(8080);
    }
}
