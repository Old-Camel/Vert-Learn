package com.xc.vert;

import io.vertx.core.Vertx;

public class main
{
    public static void main(String[] args)
    {
        Vertx.vertx().deployVerticle(Verticle1.class.getName());
    }
}
