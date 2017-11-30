package com.yunzainfo.pitcher.pushserver;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.stomp.*;

/**
 * 徐成
 */
public class StompS extends AbstractVerticle
{
    @Override
    //创建stomp服务端
    public void start(Future<Void> fut) throws Exception
    {

        StompServer server = StompServer.create(vertx, new StompServerOptions()
                //.setPort(-1) // 设置不支持tcp协议

                .setWebsocketBridge(true) // 设置支持websocket
                .setWebsocketPath("/")) // websocket的路径
                .handler(StompServerHandler.create(vertx).destinationFactory((v, name) ->
                {
                    if (name.startsWith("/queue")) {
                        return Destination.queue(vertx, name);
                    } else if (name.startsWith("/forbidden")) {
                        return null;
                    } else {
                        return Destination.topic(vertx, name);
                    }
                }).receivedFrameHandler(frame ->
                        {
                        }
                        //接受到消息的处理器,待添加
                        //System.out.println(frame.frame().getBody())
                )).writingFrameHandler(frame ->
                {
                    try {
                       // 发送之前的处理器
                       // System.out.println(frame.frame());
                       // if(frame.frame().getBody()!=null) {
                       //     System.out.println(frame.frame().getBody());
                       // }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).listen();

        HttpServer http = vertx.createHttpServer(
                new HttpServerOptions().setWebsocketSubProtocols("v10.stomp, v11.stomp")
        ).websocketHandler(server.webSocketHandler())
                .listen(9001, rs ->
                {
                    if (rs.failed()) {
                        System.out.println("启动失败");
                    } else {
                        System.out.println("启动成功");
                    }
                });
    }
}
