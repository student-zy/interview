package com.example.interview.java8.optional;




import java.util.Objects;

/**
 * @program: demo_
 * @description:
 * @author: ZhaoYe
 * @create: 2022-02-05 22:09
 **/
public class Boy {

    private String name;

    public Boy() {
    }

    public Boy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {

            return true;
        }
        if (o == null || getClass() != o.getClass()) {

            return false;
        }
        Boy boy = (Boy) o;
        return Objects.equals(name, boy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}