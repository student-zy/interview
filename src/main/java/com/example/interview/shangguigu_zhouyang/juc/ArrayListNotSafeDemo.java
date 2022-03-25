package com.example.interview.shangguigu_zhouyang.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: demo_
 * @description:  集合类不安全之并发修改异常
 * @author: ZhaoYe
 * @create: 2021-12-26 17:23
 **/
public class ArrayListNotSafeDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //List<String> list = new Vector<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

    }
}