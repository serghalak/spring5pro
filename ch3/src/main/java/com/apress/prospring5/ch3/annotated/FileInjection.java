package com.apress.prospring5.ch3.annotated;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class FileInjection {

    public static void main(String[] args) {
        GenericXmlApplicationContext context=
                new GenericXmlApplicationContext();
        context.load("classpath:app-context-annotation.xml");
        context.refresh();
        Singer singerBean = context.getBean(Singer.class);
        singerBean.sing();
        context.close();
    }
}
