package com.example.interview.java8.stream;



import com.example.interview.java8.Employee;
import com.example.interview.java8.Employee.Status;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author zhaoye
 * @date 2018/7/9
 */
public class TestStreamAPI2 {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "李四", 59, 6666.66, Status.BUSY),
            new Employee(102, "张三", 18, 9999.99, Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Status.BUSY)
    );

    /**
		映射
		map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流

		类似于add() 和addAll()
	 */
    @Test
    public void test1(){

        emps.stream()
                .map((e)-> e.getName())
                .forEach(System.out::println);

        System.out.println("--------------");

        List<String> strList = Arrays.asList("aa", "xx", "cc", "vv", "bb", "nn");

        strList.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("--------------");

        Stream<Stream<Character>> stream2 = strList.stream()
                .map(TestStreamAPI2::filterCharacter);

        stream2.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        System.out.println("---------------------------------------------");

        Stream<Character> stream3 = strList.stream()
                .flatMap(TestStreamAPI2::filterCharacter);

        stream3.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    /**
    sorted()(Comparable)——自然排序
    sorted(Comparator com)——定制排序
 */
    @Test
    public void test2(){
        emps.stream()
                .map(Employee::getName)
                .sorted()
                .forEach(System.out::println);

        System.out.println("------------------------------------");

        emps.stream()
                .sorted((x, y) -> {
                    if(x.getAge() == y.getAge()){
                        return x.getName().compareTo(y.getName());
                    }else{
                        return Integer.compare(x.getAge(), y.getAge());
                    }
                }).forEach(System.out::println);
        System.out.println("============================================");
    }


    @Test
    public void demo(){

        String s1 = "战三";
        String s2 = "李四是";
        System.out.println(s1.compareTo(s2));
    }

}
