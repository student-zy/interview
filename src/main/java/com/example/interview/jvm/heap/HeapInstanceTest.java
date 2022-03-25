package com.example.interview.jvm.heap;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * @program: demo_
 * @description: OOM域垃圾回收
 * @author: ZhaoYe
 * @create: 2021-07-25 15:55
 *
 * -Xms600m -Xmx600m
 **/
public class HeapInstanceTest {

    byte[] buffer = new byte[new SecureRandom().nextInt(1024 * 200)];

    public static void main(String[] args) {

        ArrayList<HeapInstanceTest> list = new ArrayList<HeapInstanceTest>();
        while (true) {
            list.add(new HeapInstanceTest());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}