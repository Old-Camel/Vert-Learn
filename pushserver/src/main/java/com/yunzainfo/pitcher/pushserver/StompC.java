package com.yunzainfo.pitcher.pushserver;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.stomp.StompClient;
import io.vertx.ext.stomp.StompClientConnection;

public class StompC extends AbstractVerticle
{
    @Override
    public void start() throws Exception
    {
        StompClient client=StompClient.create(vertx).connect(8080,"0.0.0.0", ar->{
            if (ar.succeeded()) {
                StompClientConnection connection = ar.result();
                connection.subscribe("/queue",
                        frame -> System.out.println("Just received a frame from /queue : " + frame));
            }else{
                System.out.println("连接失败");
            }
        });
    }

    public static void main(String[] args)
    {
        Vertx vertx=Vertx.vertx();
        StompClient client=StompClient.create(vertx).connect(8080,"0.0.0.0", ar->{
            if (ar.succeeded()) {
                StompClientConnection connection = ar.result();
                connection.subscribe("/queue",
                        frame -> System.out.println("Just received a frame from /queue : " + frame));
            }else{
                System.out.println("连接失败");
            }
        });
    }
}
