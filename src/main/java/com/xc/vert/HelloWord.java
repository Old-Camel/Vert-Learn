package com.xc.vert;

import io.vertx.core.Vertx;

public class HelloWord
{
    public static void main(String[] args) {
        // Create an HTTP server which simply returns "Hello World!" to each request.
        Vertx.vertx().createHttpServer().requestHandler(r -> r.response().end("test")).listen(8080);
    }
}
