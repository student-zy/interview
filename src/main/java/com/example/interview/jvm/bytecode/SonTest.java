package com.example.interview.jvm.bytecode;

/**
 * @program: demo_
 * @description:
 * @author: ZhaoYe
 * @create: 2021-09-10 10:18
 **/
public class SonTest {
    public static void main(String[] args) {
        Father f = new Son();
        System.out.println("f.x ="+f.x);

    }
}

class Father{
    int x= 10;
    public Father(){
        this.print();
        x = 20;
    }

    public void print() {
        System.out.println("Father.x = " + x);
    }
}
class Son extends Father{
        int x = 30;
        public Son(){
            this.print();
            x = 40;
        }

    @Override
    public void print() {
        System.out.println("Son.x = " + x);
    }
}
