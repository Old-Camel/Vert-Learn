package com.yunzainfo.pitcher.pushserver;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.stomp.StompClient;
import io.vertx.ext.stomp.StompClientConnection;
import io.vertx.ext.stomp.StompClientOptions;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

/**
 * 徐成
 */
public class PushClient
{
    public static void send(String topic, String message)
    {
        Vertx vertx = Vertx.vertx();
        StompClient client = StompClient.create(vertx, new StompClientOptions().setHost("192.168.182.99"))
                .connect(ar ->
                {
                    if (ar.succeeded()) {
                        StompClientConnection connection = ar.result();
                        connection.errorHandler(frame -> System.out.println("连接断开 : " + frame));
                        try {
                            connection.send(topic, Buffer.buffer(Base64.getEncoder().encodeToString(message.getBytes("utf-8"))), frame ->
                                    System.out.println("消息被处理")
                            );
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        connection.disconnect();
                        vertx.close();
                    } else {
                        System.out.println("没有连接成功: " + ar.cause().toString());
                    }
                });
    }

    public static void send(String topic, List<String> messages)
    {
        Vertx vertx = Vertx.vertx();
        StompClient client = StompClient.create(vertx, new StompClientOptions().setHost("192.168.182.99"))
                .connect(ar ->
                {
                    if (ar.succeeded()) {
                        StompClientConnection connection = ar.result();
                        connection.errorHandler(frame -> System.out.println("连接断开 : " + frame));
                        try {
                                for (String message : messages) {
                                    try {
                                        connection.send(topic, Buffer.buffer(Base64.getEncoder().encodeToString(message.getBytes("utf-8"))), frame ->
                                                System.out.println("消息被处理")
                                        );
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }
                                }
                                connection.disconnect();
                                vertx.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {
                        System.out.println("没有连接成功: " + ar.cause().toString());
                    }
                });
    }

}
