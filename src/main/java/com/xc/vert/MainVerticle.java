package com.xc.vert;

import io.vertx.core.AbstractVerticle;

public class MainVerticle extends AbstractVerticle
{
    @Override
    public void start() throws Exception
    {
      vertx.deployVerticle(Verticle1.class.getName());
    }
}
