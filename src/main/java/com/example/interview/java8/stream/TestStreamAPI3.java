package com.example.interview.java8.stream;



import com.example.interview.java8.Employee;
import com.example.interview.java8.Employee.Status;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zhaoye
 * @date 2018/7/9
 */


public class TestStreamAPI3 {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "李四", 59, 6666.66, Status.BUSY),
            new Employee(102, "张三", 18, 9999.99, Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Status.BUSY)
    );

	/*
		终止操作 : 归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
		        起始值       二元运算
	 */

    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Integer sum = list.stream()
                .reduce(0, Integer::sum);

        System.out.println(sum);

        System.out.println("----------------------------------------");

        Optional<Double> optional = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(optional.get());

    }

    //需求：搜索名字中 “六” 出现的次数
    @Test
    public void test4(){

        long count = emps.stream()
                .filter((e) -> e.getName().contains("六"))
                .count();
        System.out.println(count);

       //怎样用 map 和 reduce 方法数一数流中有多少个Employee呢？
        Optional<Integer> reduce = emps.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }


    /*
		怎样用 map 和 reduce 方法数一数流中有多少个Employee呢？
	 */

    @Test
    public void test5(){
        Optional<Integer> count = emps.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(count.get());
    }


    //3. 终止操作
	/*
		allMatch——检查是否匹配所有元素
		anyMatch——检查是否至少匹配一个元素
		noneMatch——检查是否没有匹配的元素
		findFirst——返回第一个元素
		findAny——返回当前流中的任意元素
		count——返回流中元素的总个数
		max——返回流中最大值
		min——返回流中最小值
	 */

	@Test
    public void test2(){

        long count = emps.stream()
                .filter((e)->e.getStatus().equals(Status.BUSY))
                .count();
        System.out.println(count);

        Optional<Double> max = emps.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(max.get());

    }


	@Test
    public void test(){

        boolean b = emps.stream()
                .allMatch((e1) -> e1.getStatus().equals(Status.BUSY));
        System.out.println(b);

        boolean b1 = emps.stream()
                .anyMatch((e1) -> e1.getStatus().equals(Status.BUSY));
        System.out.println(b1);

        boolean b2 = emps.stream()
                .noneMatch((e1) -> e1.getStatus().equals(Status.BUSY));
        System.out.println(b2);


        Optional<Employee> op2 = emps.parallelStream()
                .filter((e) -> e.getStatus().equals(Status.BUSY))
                .findAny();

        System.out.println(op2.get());

    }

}
