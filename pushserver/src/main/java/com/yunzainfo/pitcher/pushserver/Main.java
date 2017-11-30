package com.yunzainfo.pitcher.pushserver;


import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.stomp.*;


public class Main
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        StompServer server = StompServer.create(vertx, new StompServerOptions()
                //.setPort(-1)

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
                            System.out.println(frame.frame().getBody());
                        }
                )).writingFrameHandler(

                        frame->{
                            Buffer body = frame.frame().getBody();
                            System.out.println(body+"2222222222222");
                            if (body!=null){
                                try {
                                    //String s = new ChangeCharset().changeCharset(body.toString(),"UTF-8","");
                                    //frame.frame().setHeaders(Headers.create("content-length","100"));
                                    //frame.frame().setB)
                                    //frame.frame().setBody(Buffer.buffer());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                System.out.println(body.toString());
                            }
                        }
                ).listen();

        HttpServer http = vertx.createHttpServer(
                new HttpServerOptions().setWebsocketSubProtocols("v10.stomp, v11.stomp")
                )
                .websocketHandler(server.webSocketHandler())
                .listen(9001, rs ->
                {
                    if (rs.failed()) {
                        System.out.println("启动失败");
                    } else {
                        System.out.println("启动成功");
                    }
                });
       /* HttpServer http = vertx.createHttpServer();
        Router router = Router.router(vertx);

        SockJSHandlerOptions options = new SockJSHandlerOptions().setHeartbeatInterval(2000)  ;

        SockJSHandler sockJSHandler = SockJSHandler.create(vertx, options);

        router.route("/*").handler(sockJSHandler);

        http.requestHandler(router::accept).websocketHandler(server.webSocketHandler()).listen(9001);*/
    }
}


