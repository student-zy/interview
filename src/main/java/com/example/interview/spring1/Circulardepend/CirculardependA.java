package com.example.interview.spring1.Circulardepend;

/**
 * @program: demo_
 * @description:
 * @author: ZhaoYe
 * @create: 2022-01-12 15:12
 **/
public class CirculardependA {

    private CirculardependB b;

    public  CirculardependB getB(){
        return b;
    }

    public void setB(CirculardependB b){
        this.b = b;
    }

    public CirculardependA(){
        System.out.println("-------A created success");
    }


}