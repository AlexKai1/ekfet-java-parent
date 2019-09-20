package com.ekfet.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.midi.Soundbank;

public class SpringIocServer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("classpath:spring-ioc.xml");
        applicationContext.refresh();
        HelloSpring spring = (HelloSpring) applicationContext.getBean("helloSpring2");
        System.out.println(spring.getIndex());
    }
}
