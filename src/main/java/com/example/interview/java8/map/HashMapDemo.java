package com.example.interview.java8.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author zhaoye
 * @date 2018/7/5
 */
public class HashMapDemo {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String,String>(20);
        map.put("张三丰","太极拳");
        map.put("张无忌","九阳神功");
        map.put("乔峰","降龙十八掌");
        map.put("段誉","六脉神剑");
        map.put("欧阳锋","蛤蟆功");
        map.put("梅超风","九阴白骨爪");

        //方法一
        for(Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println("方法一：key ="+entry.getKey()+"---value="+entry.getValue());
        }

        //方法二
        for(String key:map.keySet()) {
            System.out.println("方法二：key = "+key);
        }

        for(String value:map.values()) {
            System.out.println("方法二：value = "+value);
        }
        //方法三
        Iterator<Map.Entry<String,String>> entries = map.entrySet().iterator();
        while(entries.hasNext()) {
            Map.Entry<String,String> entry = entries.next();
            System.out.println("方法三：key = "+entry.getKey()+"--value="+entry.getValue());
        }

        //方法四
        for(String key:map.keySet()) {
            String value = map.get(key);
            System.out.println("方法四：Key = " + key + ", Value = " + value);
        }


    }

}
