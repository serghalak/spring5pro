package com.apress.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

public class MessageDigestFactoryDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context=new GenericXmlApplicationContext();
        context.load("classpath:spring/ch4/app-context-xml.xml");
        context.refresh();

        MessageDigester digester = context.getBean("digester"
                , MessageDigester.class);
        digester.digest("Hello world");

        MessageDigest shaDigest = context.getBean("shaDigest"
                , MessageDigest.class);
        System.out.println(shaDigest.digest("Hello world".getBytes()));

    }
}
