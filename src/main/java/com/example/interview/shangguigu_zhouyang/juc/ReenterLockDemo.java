package com.example.interview.shangguigu_zhouyang.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo_
 * @description:  可重入锁和递归锁代码验证
 * @author: ZhaoYe
 * @create: 2022-01-11 10:59
 **/

public class ReenterLockDemo {


    public static void main(String[] args) {
        Phone phone = new Phone();

        /*
         * 因为Phone实现了Runnable接口
         */
        Thread t3 = new Thread(phone, "t3");
        Thread t4 = new Thread(phone, "t4");
        t3.start();
        t4.start();
    }
}

/**
 * 资源类
 */
class Phone implements Runnable{

    ReentrantLock lock = new ReentrantLock();

    /**
     * set进去的时候，就加锁，调用set方法的时候，能否访问另外一个加锁的set方法
     */
    public void getLock() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t get Lock");
            setLock();
        } finally {
            lock.unlock();
        }
    }

    public void setLock() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t set Lock");
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        getLock();
    }
}
