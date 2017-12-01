package com.xc.vert;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Future;

public class MyFirstVerticle extends AbstractVerticle
{
    @Override
    public void start(Future<Void> fut)
    {
      /*  vertx.createHttpServer().requestHandler(
            r -> r.response().end("<h1>Hello from my first Vert.x 3 application</h1>")
        ).listen(8080, result ->
        {
            if (result.succeeded()) {
                fut.complete();
            } else {
                fut.fail(fut.cause());
            }
        });*/
        System.out.println(config().getString("name"));
        System.out.println(System.getenv("HOME"));
        long l = vertx.setTimer(10000, r ->
        {
            System.out.println(r);
            System.out.println("111");
        });
        System.out.println("diyici");
        vertx.setTimer(5000,id->{
            System.out.println(id);
           vertx.cancelTimer(l);
            System.out.println("quxiao");
        });


    }
}
