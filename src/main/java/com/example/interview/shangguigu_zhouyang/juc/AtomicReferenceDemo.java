package com.example.interview.shangguigu_zhouyang.juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: demo_
 * @description: 原子引用
 * @author: ZhaoYe
 * @create: 2021-12-25 20:56
 **/
public class AtomicReferenceDemo {

    public static void main(String[] args) {

        User z3 = new User( "z3",22);
        User li4 = new User("li4" ,25);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3, li4)+"\t"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3, li4)+"\t"+atomicReference.get().toString());

    }
}

@Data
@ToString
@AllArgsConstructor
class User{
    String userName;
    int age;
}