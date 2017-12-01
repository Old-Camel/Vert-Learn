package com.xc.vert;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;

import javax.lang.model.element.VariableElement;

/**
 * TODO:TODO
 * Auther:徐成
 * Date:2017/12/1
 * Email:old_camel@126.com
 */
public class EventBusTest {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        EventBus eventBus = vertx.eventBus();
        MessageConsumer<Object> consumer = eventBus.consumer("space.xucheng", message -> {
            System.out.println("收到消息" + message.body());
        });
       /* MessageConsumer<String> xucheng = eventBus.consumer("xucheng");
        xucheng.handler(message->{
            System.out.println(message.body());
        });*/
        consumer.completionHandler(res->{
            if (res.succeeded()) {
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        });
/*
        consumer.unregister(res->{
            System.out.println("quxiao");
        });
*/

    }
}
