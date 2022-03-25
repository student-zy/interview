package com.example.interview.recursion;

import java.util.Arrays;
import java.util.List;

/**
 * @program: interview
 * @Author: zy_zhao
 * @Date: 2022-03-11
 */
public class TestDemo {

    public static void main(String[] args) {

        String str = "11scrscrscriptiptalalertertiptaa";
        String test = test(str);
        System.out.println("test = " + test);
    }

    private static String test(String str) {

        str = str.replaceAll("script", "");
        str = str.replaceAll("alert", "");
        List<String> strings = Arrays.asList("<","script","alert");

        boolean flag = false;
        for (String string : strings) {
            if(str.contains(string)){
                test(str);

            }
        }

        return str;

    }
}