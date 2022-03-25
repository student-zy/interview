package com.example.interview.shangguigu_zhouyang.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo_
 * @description: 一个初始值为0的变量，两个线程对其交替操作，一个加1，一个减1，来5轮
 * @author: ZhaoYe
 * @create: 2021-12-28 14:54
 **/
public class ProdConsumerTraditionDemo {
    public static void main(String[] args) {

        myResource myResource = new myResource();

        //t1生产
        new Thread(() ->{
            for (int i = 1; i <= 5 ; i++) {
                try {
                    myResource.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();


        //t2消费
        new Thread(() ->{
            for (int i = 1; i <=5 ; i++) {
                try {
                    myResource.reduce();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();
    }
}

/**
 *资源类
*/

class myResource{

    private int number = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    /**
     *生产
    */

    public void increment() throws Exception{

        //同步代码块 ，加锁
        lock.lock();
        try {
            //判读
            while (number != 0){
                //等待不能生产
                condition.await();
            }
            //生产
            number++;
            System.out.println(Thread.currentThread().getName() + "\t " + number);
            // 通知 唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    /**
     *消费
     */
    public void reduce() throws Exception{

        lock.lock();
        try {
            //判读
            while (number == 0){
                //等待不能消费
                condition.await();
            }
            //消费
            number--;
            System.out.println(Thread.currentThread().getName() + "\t " + number);
            // 通知 唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}


