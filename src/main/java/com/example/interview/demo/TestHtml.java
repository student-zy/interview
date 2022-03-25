package com.example.interview.demo;

import org.springframework.web.util.HtmlUtils;

/**
 * @program: interview
 * @Author: zy_zhao
 * @Date: 2022-03-16
 */
public class TestHtml {
    public static void main(String[] args) {
        String specialStr = "<div id=\"testDiv\">test1;test2;alert(`1`)</div>";
        // ①转换为HTML转义字符表示
        String str1 = HtmlUtils.htmlEscape(specialStr);
        System.out.println("str1 = " + str1);
        // ②转换为数据转义表示
        String str2 = HtmlUtils.htmlEscapeDecimal(specialStr);
        System.out.println("str2 = " + str2);

        //③转换为十六进制数据转义表示
        String str3 = HtmlUtils.htmlEscapeHex(specialStr);
        System.out.println("str3 = " + str3);

        // ④下面对转义后字符串进行反向操作
        System.out.println(HtmlUtils.htmlUnescape(str1));
        System.out.println(HtmlUtils.htmlUnescape(str2));
        System.out.println(HtmlUtils.htmlUnescape(str3));
    }
}