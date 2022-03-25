package com.example.interview.java8.stream;



import com.example.interview.java8.Employee;
import com.example.interview.java8.Employee.Status;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
一、 Stream 的操作步骤
1.创建 Stream
2.中间操作
3.终止操作
 * @author zy
 * @date 2018/7/9
 */

public class StreamApiTest {

    List<Employee> ems = Arrays.asList(
            new Employee(101, "李四", 59, 6666.66, Status.BUSY),
            new Employee(102, "张三", 18, 9999.99, Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Status.BUSY)
    );


    /*
	  筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */

    //中间操作：多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理！
    //而在终止操作时一次性全部处理，称为“惰性求值”


    /****
     //内部迭代：迭代部分stream API自己内部已经完成
    */

    @Test
    public void test2(){
        //filter——接收 Lambda ， 从流中排除某些元素。
        Stream<Employee> stream = ems.stream().filter((e) -> {
           // System.out.println("中间操作----");
            return e.getAge() >= 35;
        });

        //只有当做终止操作时，所有的中间操作会一次性的全部执行，称为“惰性求值”
        stream.forEach(System.out::println);
    }

    @Test
    public void test4(){

        Stream<Employee> stream = ems.stream().filter((e) -> {
            System.out.println("短路与----");//||  &&
            return e.getSalary() >= 5000;
        }).limit(3);

        stream.forEach(System.out::println);

    }

    @Test
    public void test5(){
        ems.parallelStream()
                .filter((e) -> e.getSalary() >= 5000)
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void test6(){
        ems.stream()
            .distinct()
            .forEach(System.out::println);

    }
    /***
     //外部迭代
    */

    @Test
    public void test3(){

        Iterator<Employee> it = ems.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

    }



   /***
    *  //获取stream的四种方式
    * @param:
    * @return: void
    * @author zhaoYe
    * @date: 2022/2/5
   */

    @Test
    public void test1(){

        //法一：可以通过Collection系列集合提供的stream()或parallelStream()方法
            ArrayList<String> list = new ArrayList<>();
        //获取一个顺序流
        Stream<String> stream = list.stream();
        //获取一个并行流
        Stream<String> parallelStream = list.parallelStream();

        //方法二:Arrays 的静态方法stream()
        Stream<Object> stream1 = Arrays.stream(new Object[10]);

        //方法三：用静态方法Stream.of()
        Stream<String> stream2 = Stream.of("aa", "bb", "cc", "dd");

        //方法四：使用静态方法Stream.iterate() 和Stream.generate(), 创建无限流。
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 3);
        stream3.limit(10).forEach(System.out::println);

        System.out.println("-------------------------------------");
        Stream<Double> stream4 = Stream.generate(Math::random);
        stream4.limit(10).forEach(System.out::println);



    }
}
