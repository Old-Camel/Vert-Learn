package com.xc.vert;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO:TODO
 * Auther:徐成
 * Date:2017/12/14
 * Email:old_camel@126.com
 */
public class User {
    private static final AtomicInteger COUNTER = new AtomicInteger();

    public static AtomicInteger getCOUNTER() {
        return COUNTER;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String name;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public User() {
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.id = COUNTER.getAndIncrement();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
