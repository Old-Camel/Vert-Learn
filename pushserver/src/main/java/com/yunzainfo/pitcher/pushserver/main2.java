package com.yunzainfo.pitcher.pushserver;


import io.vertx.core.Vertx;
import io.vertx.ext.stomp.Destination;
import io.vertx.ext.stomp.StompServer;
import io.vertx.ext.stomp.StompServerHandler;

public class main2
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();


        StompServer server = StompServer.create(vertx)
                .handler(StompServerHandler.create(vertx)
                        .destinationFactory((v, name) ->
                        {
                            if (name.startsWith("/queue")) {
                                return Destination.queue(vertx, name);
                            } else {
                                return Destination.topic(vertx, name);
                            }
                        }))
                .listen();
    }
}
