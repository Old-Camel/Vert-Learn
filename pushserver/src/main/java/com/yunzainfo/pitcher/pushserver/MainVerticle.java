package com.yunzainfo.pitcher.pushserver;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MainVerticle extends AbstractVerticle
{
    @Override
    public void start(Future<Void> fut) throws Exception
    {
        vertx.createHttpServer().requestHandler(res -> res.response().putHeader("content-type", "text/plain").end("hello")).listen(8080);
    }

}