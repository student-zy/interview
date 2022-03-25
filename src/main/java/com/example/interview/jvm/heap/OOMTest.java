package com.example.interview.jvm.heap;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * @program: demo_
 * @description: OOM测试
 * @author: ZhaoYe
 * @create: 2021-07-23 21:15
 **/
public class OOMTest {

    public static void main(String[] args) {
        ArrayList<Picture> list = new ArrayList<>();
        while(true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Picture(new SecureRandom().nextInt(1024 * 1024)));
        }
    }
}

class Picture {
    private byte[] pixels;

    public Picture(int length) {
        this.pixels = new byte[length];
    }
}
