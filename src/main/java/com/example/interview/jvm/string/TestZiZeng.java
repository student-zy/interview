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
public class TestZiZeng {

    public static void main(String[] args) {
       test1();
    }

    private static void test1() {

        int i1 = 10;
        int i2 = i1++;

        int i3 = 10;
        int i4 = ++i3;
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
        System.out.println("i4 = " + i4);

        System.out.println("------------------------------>1");

        int i5 = 10;
        i5 = i5++;

        int i6 = 10;
        i6 = ++i6;

        System.out.println("i5 = " + i5);
        System.out.println("i6 = " + i6);

        System.out.println("---------------------------------------------->2");

        int i7 = 10;
        int i8 = i7++ + ++i7;

        int i9 = 10;
        int i10 = ++i9 + i9++;

        System.out.println("i7 = " + i7);
        System.out.println("i8 = " + i8);
        System.out.println("i9 = " + i9);
        System.out.println("i10 = " + i10);

    }

}