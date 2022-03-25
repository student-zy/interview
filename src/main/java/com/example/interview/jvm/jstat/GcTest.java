package com.example.interview.jvm.jstat;

import java.util.ArrayList;

/**
 * @program: demo_
 * @description: GCTest
 * @author: ZhaoYe
 * @create: 2021-12-18 20:50
 * -Xms60m -Xmx60m -XX:SurvivorRatio=8
 **/
public class GcTest {

    public static void main(String[] args) {

        ArrayList<byte[]> list = new ArrayList<>();
        int num = 1000;
        for (int i = 0; i < num ; i++) {
            byte[] arr =  new byte[1024 * 100];
            list.add(arr);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

}