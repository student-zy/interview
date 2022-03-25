package com.example.interview.demo;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: interview
 * @Author: zy_zhao
 * @Date: 2022-02-14
 */
public class TestPattern {

   static  Pattern p = Pattern.compile("\\s*|\t|\r|\n");
    public static void main(String[] args) {

        String s = "你好中国\r你好世界\r啊哈哈" ;
        String ss = s.replaceAll("\\s*|\t|\r|\n","");
        System.out.println("ss = " + ss);
        System.out.println("s原 = " + s);
        Matcher matcher = p.matcher(s);
        s = matcher.replaceAll("");
        System.out.println("s = " + s);
    }
    @Test
    public void testString(){
        String ss = "今天,天气真好,阳光明媚";
        String s = ss.replaceAll(",", "");
        System.out.println("s = " + s);
    }
}