package com.example.interview.jvm.string;

/**
 * @program: demo_
 * @description: 测试
 * @author: ZhaoYe
 * @create: 2021-08-02 22:52
 **/
public class DemoIntern {

    public static void main(String[] args) {

        for(int i=0; i<100000;i++){
            String.valueOf(i).intern();
        }

        try {
            Thread.sleep(1000000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}