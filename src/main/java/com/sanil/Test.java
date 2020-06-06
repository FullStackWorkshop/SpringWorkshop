package com.sanil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Test {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Test.class);

        System.out.println("beans: "+ Arrays.toString(context.getBeanDefinitionNames()));
    }
}
