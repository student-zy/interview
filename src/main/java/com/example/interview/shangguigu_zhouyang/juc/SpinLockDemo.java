package com.example.interview.shangguigu_zhouyang.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: demo_
 * @description:  手写一个自旋锁
 * @author: ZhaoYe
 * @create: 2021-12-27 14:43
 **/
public class SpinLockDemo {


    /***
     *
     现在的泛型装的是Thread，原子引用线程
    */
    AtomicReference<Thread> atomicReference  = new AtomicReference<>();

    public  void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in");
        int i = 0;
        // 开始自旋，期望值是null，更新值是当前线程，如果是null，则更新为当前线程，否者自旋
        while(!atomicReference.compareAndSet(null,thread)){
            ++i;
           System.out.println("====="+i+"次");
        }
    }


    public void myUnLock(){

        // 获取当前进来的线程
        Thread thread = Thread.currentThread();

        // 自己用完了后，把atomicReference变成null
        atomicReference.compareAndSet(thread, null);

        System.out.println(Thread.currentThread().getName() + "\t invoked myUnlock()");
    }




    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();

        // 启动t1线程，开始操作
        new Thread(() -> {

            // 开始占有锁
            spinLockDemo.myLock();

            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(".....五秒后.....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 开始释放锁
            spinLockDemo.myUnLock();

        }, "t1").start();


        // 让main线程暂停1秒，使得t1线程，先执行
        try {

            TimeUnit.SECONDS.sleep(1);
            System.out.println(".....一秒后.....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 1秒后，启动t2线程，开始占用这个锁
        new Thread(() -> {

            // 开始占有锁
            spinLockDemo.myLock();
            // 开始释放锁
            spinLockDemo.myUnLock();

        }, "t2").start();


    }
}