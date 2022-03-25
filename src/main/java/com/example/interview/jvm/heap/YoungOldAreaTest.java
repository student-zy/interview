package com.example.interview.jvm.heap;

/**
 * @program: demo_
 * @description: 测试：大对象直接进入老年代
 * @author: ZhaoYe
 * @create: 2021-07-25 21:26
 *
 * -Xms60m -Xmx60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 **/
public class YoungOldAreaTest {

    public static void main(String[] args) {

        //20m
        byte[] bytes = new byte[1024 * 1024 * 20];
    }
}