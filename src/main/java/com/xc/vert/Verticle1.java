package com.xc.vert;

import io.vertx.core.AbstractVerticle;

public class Verticle1 extends AbstractVerticle
{
    @Override
    public void start() throws Exception
    {
        vertx.createHttpServer().requestHandler(res -> res.response().putHeader("content-type", "text/plain").end("hello")).listen(8080);
    }
}
