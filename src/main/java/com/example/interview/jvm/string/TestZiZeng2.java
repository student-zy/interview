package com.example.interview.jvm.string;

/**
 *
 *自加自减运算规律：
 * 	1）当自加自减在变量的右侧时，需要先把变量空间中的值临时存储，也就是说在内存中需要开辟一个临时空间，
 * 	把这个值保存到临时空间中。然后给原来变量空间中+1或-1，最后把临时存储的那个数据和其他的运算符号进行运算。
 * 2）当自加自减在变量的左侧时，这时直接给变量空间+1 或 -1，然后把空间中的值与其他的运算符号进行运算。
 *
 * @author zhaoye
 */
public class TestZiZeng2 {


    public static void main(String[] args) {

        double d = 5/2;
        float f = 5/2;

        Integer integer = new Integer(127);
        Integer integer2 = new Integer(127);
        //false
//        System.out.println(integer == integer2);
        //true
        System.out.println(integer.equals(integer2));
        //d=2.0
        System.out.println("d="+d);
        //f=2.0
        System.out.println("f = " + f);

        double d2 = 4321 / 1000.0 * 1000;

        System.out.println("d2 = " + d2);
        int i = 0;
        i++;
        System.out.println("i1="+i);
        int j = i;
        System.out.println("i="+i+"----->j="+j);
        change();
    }

    private static void change() {

         int a = 2;
         int b = a++;
         int c = 0;
         c++;
         //c=0
        System.out.println("c = " + c);

        int d = 0;
        d=++d;
        //d=1
        System.out.println("d = " + d);
//        a=3
        System.out.println("a = " + a);
//        b=2
        System.out.println("b = " + b);

    }


}
