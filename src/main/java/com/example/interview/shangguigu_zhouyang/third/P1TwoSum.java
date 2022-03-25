package com.example.interview.shangguigu_zhouyang.third;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo_
 * @description: 两数之和
 * @author: ZhaoYe
 * @create: 2022-01-07 14:02
 **/
public class P1TwoSum {
    public static void main(String[] args) {


        int[] nums = new int[]{2,7,11,5};
        int target = 7;
        int[] ints = twoSum(nums, target);
        if(ints!=null){
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

}