package com.xc.vert;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;

/**
 * TODO:TODO
 * Auther:徐成
 * Date:2017/12/1
 * Email:old_camel@126.com
 */
public class EventBusclient {
    public static void main(String[] args) {
        Vertx vert = Vertx.vertx();
        EventBus eventBus = vert.eventBus();
        eventBus.publish("space.xucheng","vceshirc");


    }
}
