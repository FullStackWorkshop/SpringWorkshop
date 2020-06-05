package com.sanil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("com.sanil")
public class Test {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);

        System.out.println("beans: "+ Arrays.toString(context.getBeanDefinitionNames()));
    }
}
