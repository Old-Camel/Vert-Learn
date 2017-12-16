package com.xc.vert;

import com.xc.vert.util.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;

public class Verticle1 extends AbstractVerticle
{
    public static void main(String[] args) {
        Runner.runExample(Verticle1.class);
    }
    @Override
    public void start() throws Exception
    {

        //vertx.createHttpServer().requestHandler(res -> res.response().putHeader("content-type", "application/json;charset=utf-8").end(Json.encode(new User()))).listen(8080);
    }
}
