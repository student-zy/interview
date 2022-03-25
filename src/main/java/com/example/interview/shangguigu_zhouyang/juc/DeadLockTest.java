package com.example.interview.shangguigu_zhouyang.juc;

import java.util.concurrent.TimeUnit;

/**
 * @program: demo_
 * @description: 死锁demo
 * @author: ZhaoYe
 * @create: 2021-12-29 15:12
 **/
public class DeadLockTest {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        new Thread(() -> {
            synchronized (a){
                System.out.println(Thread.currentThread().getName()+"已经获得a锁");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"睡眠1s结束");
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName()+"已经获得b锁");
                }
            }
        },"线程1").start();
        new Thread(() -> {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "已经获得b锁");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"睡眠1s结束");
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "已经获得a锁");
                }
            }
        },"线程2").start();
    }
}