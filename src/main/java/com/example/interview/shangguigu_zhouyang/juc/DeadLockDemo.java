package com.example.interview.shangguigu_zhouyang.juc;

import java.util.concurrent.TimeUnit;

/**
 * @program: demo_
 * @description: 死锁代码演示
 * @author: ZhaoYe
 * @create: 2021-12-29 11:14
 **/
public class DeadLockDemo {
    public static void main(String[] args) {

        String lockA = "a";
        String lockB = "b";

        new Thread(new ResourceClass(lockA, lockB), "t1").start();
        System.out.println("===========================================");
        new Thread(new ResourceClass(lockB, lockA), "t2").start();


    }
}

/***
 *资源类
*/
 class ResourceClass implements Runnable{

     //定义两个锁
    private  String lockA = "a";
    private  String lockB = "b";
    public ResourceClass(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有" + lockA + "\t 尝试获取：" + lockB);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("******************************************");

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有" + lockB + "\t 尝试获取：" + lockA);
            }
        }
    }
}
