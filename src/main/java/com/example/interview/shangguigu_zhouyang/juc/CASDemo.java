package com.example.interview.shangguigu_zhouyang.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: demo_
 * @description: CAS
 * @author: ZhaoYe
 * @create: 2021-12-25 01:37
 **/
public class CASDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(3);
        /*
         * 一个是期望值，一个是更新值，但期望值和原来的值相同时，才能够更改
         * 假设三秒前，我拿的是3，也就是expect为3，然后我需要更新成 10
         */
        System.out.println(atomicInteger.compareAndSet(3, 10) + "\t current data: " + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(3, 15) + "\t current data: " + atomicInteger.get());

        int andIncrement = atomicInteger.getAndIncrement();
        System.out.println("andIncrement = " + andIncrement);
    }
}