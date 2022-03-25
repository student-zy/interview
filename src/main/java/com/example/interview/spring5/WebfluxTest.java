package com.example.interview.spring5;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @program: interview
 * @description:
 * @author: ZhaoYe
 * @create: 2022-01-27 12:12
 **/
public class WebfluxTest {

    public static void main(String[] args) {

        Flux.just(1,2,3,4).subscribe(System.out::println);
        Mono.just(66).subscribe(System.out::println);

    }
}