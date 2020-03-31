package com.apress.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class NameSingerDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext context=new GenericXmlApplicationContext();
        context.load("classpath:spring/ch4/app-context-xml.xml");
        context.refresh();

        NamedSinger johnMayer = context.getBean("johnMayer", NamedSinger.class);
        johnMayer.sing();
        context.close();
    }
}
