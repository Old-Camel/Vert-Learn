package com.yunzainfo.pitcher.pushserver;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.stomp.StompClient;
import io.vertx.ext.stomp.StompClientConnection;

import java.util.ArrayList;
import java.util.List;

public class client extends AbstractVerticle

{
    @Override
    public void start() throws Exception
    {
        StompClient client = StompClient.create(vertx)
                .connect(61613,"222.30.194.175",ar -> {
                    if (ar.succeeded()) {
                        System.out.println("12111");
                        StompClientConnection connection = ar.result();
                        connection.errorHandler(frame -> System.out.println("连接断开 : " + frame));
                        //xmString = new String("徐".getBytes("UTF-8"));

                         //徐s =new String (new StringBuilder().append("徐").toString().getBytes("UTF-8"));

//String a ="动的的的的";
                        //String s = new String(a.getBytes("UTF-8"), "UTF-8");
                        connection.send("/yunzainfo/message/admin", Buffer.buffer("hello"),frame -> {
                            System.out.println("消息被处理");
                        });
                        connection.disconnect();
                    } else {
                        System.out.println("没有连接成功: " + ar.cause().toString());
                    }
                });
        client.close();
        vertx.close();
    }

    public static void main(String[] args)
    {
        /*Vertx vertx=Vertx.vertx();
        StompClient client = StompClient.create(vertx)
                .connect(61613,"192.168.182.99",ar -> {
                    if (ar.succeeded()) {
                        StompClientConnection connection = ar.result();
                        connection.errorHandler(frame -> System.out.println("连接断开 : " + frame));
                        Map<String, String> headers = new HashMap<>();
                        Headers add = Headers.create().add("content-type", "text/html;charset=unicode");
                        String s = "测试";
                        String a = null;
                        try {
                            a = new String(s.getBytes("utf-8"), "unicode");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        connection.send("/yunzainfo/message/admin",add, Buffer.buffer(a),frame -> {
                            System.out.println("消息被处理");
                        });
                        connection.disconnect();
                        vertx.close();
                    } else {
                        System.out.println("没有连接成功: " + ar.cause().toString());
                    }
                });*/
//while (true) {

        List<String> list = new ArrayList<>();
        list.add("测试");
        list.add("das");
        list.add("222");
        PushClient.send("/yunzainfo/message/admin", list);
        System.out.println("vixk");
    }
}
