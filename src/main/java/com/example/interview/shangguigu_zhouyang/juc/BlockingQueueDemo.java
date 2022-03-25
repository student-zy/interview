package com.example.interview.shangguigu_zhouyang.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: demo_
 * @description:
 * @author: ZhaoYe
 * @create: 2021-12-28 10:07
 **/
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //add();
        //offer();
//        put();
        offer2();
    }

    //当阻塞队列满时，队里会阻塞生产者线程一定时间，超过限时后生产者线程会退出
    private static void offer2() throws InterruptedException {
        //阻塞队列，需要填入默认值
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println("blockingQueue.offer(\"a\",2L, TimeUnit.SECONDS) = " + blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println("blockingQueue.offer(\"b\",2L, TimeUnit.SECONDS) = " + blockingQueue.offer("b", 2L, TimeUnit.SECONDS));
        System.out.println("blockingQueue.offer(\"c\",2L, TimeUnit.SECONDS) = " + blockingQueue.offer("c", 2L, TimeUnit.SECONDS));
        System.out.println("blockingQueue.offer(\"a\",2L, TimeUnit.SECONDS) = " + blockingQueue.offer("a", 2L, TimeUnit.SECONDS));

        System.out.println("blockingQueue.poll(2L,TimeUnit.SECONDS) = " + blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println("blockingQueue.poll(2L,TimeUnit.SECONDS) = " + blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println("blockingQueue.poll(2L,TimeUnit.SECONDS) = " + blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println("blockingQueue.poll(2L,TimeUnit.SECONDS) = " + blockingQueue.poll(2L, TimeUnit.SECONDS));
    }

    //我们使用 put的方法，添加元素时候，如果阻塞队列满了后，添加消息的线程，会一直阻塞，直到队列元素减少，会被清空，才会唤醒
    //同时使用take取消息的时候，如果内容不存在的时候，也会被阻塞
    //一般在消息中间件，比如RabbitMQ中会使用到，因为需要保证消息百分百不丢失，因此只有让它阻塞
    private static void put() throws InterruptedException {
        //阻塞队列，需要填入默认值
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        blockingQueue.put("d");
        System.out.println("===============");

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
    }

    /*
     * 我们使用 offer的方法，添加元素时候，如果阻塞队列满了后，会返回false，否者返回true
同时在取的时候，如果队列已空，那么会返回null
    */

    private static void offer() {
        //阻塞队列，需要填入默认值
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println("blockingQueue.offer(\"a\") = " + blockingQueue.offer("a"));
        System.out.println("blockingQueue.offer(\"b\") = " + blockingQueue.offer("b"));
        System.out.println("blockingQueue.offer(\"c\") = " + blockingQueue.offer("c"));
        System.out.println("blockingQueue.offer(\"d\") = " + blockingQueue.offer("d"));
        System.out.println("blockingQueue.peek() = " + blockingQueue.peek());

        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
    }

    /**
     //执行add方法，向已经满的ArrayBlockingQueue中添加元素时候，会抛出异常
    */
    private static void add() {
        //阻塞队列，需要填入默认值
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //执行add方法，向已经满的ArrayBlockingQueue中添加元素时候，会抛出异常
        System.out.println("blockingQueue.add(\"a\") = " + blockingQueue.add("a"));
        System.out.println("blockingQueue.add(\"b\") = " + blockingQueue.add("b"));
        System.out.println("blockingQueue.add(\"c\") = " + blockingQueue.add("c"));
//        System.out.println("blockingQueue.add(\"d\") = " + blockingQueue.add("d"));
        System.out.println("blockingQueue.element() = " + blockingQueue.element());
        System.out.println("blockingQueue.element() = " + blockingQueue.element());
        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
    }
}