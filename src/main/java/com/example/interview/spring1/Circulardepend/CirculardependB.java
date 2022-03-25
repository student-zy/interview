package com.example.interview.spring1.Circulardepend;

/**
 * @program: demo_
 * @description:
 * @author: ZhaoYe
 * @create: 2022-01-12 15:12
 **/
public class CirculardependB {

    private CirculardependA a;

    public CirculardependA getA(){
        return a;
    }

    public void setA(CirculardependA a){
        this.a = a;
    }

    public CirculardependB(){
        System.out.println("-------B created success");
    }
}