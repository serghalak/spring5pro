package com.apress.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DependsOnDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
        ctx.load("spring/app-context-xml.xml");
        ctx.refresh();
        Singer singer = ctx.getBean("singer", Singer.class);
        singer.sing();
        ctx.close();
    }
}
