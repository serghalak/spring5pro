package com.apress.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

public class AccessingFactoryBean {

    public static void main(String[] args) {
        GenericXmlApplicationContext context =new GenericXmlApplicationContext();
        context.load("classpath:spring/ch4/app-context-xml.xml");
        context.refresh();

        MessageDigestFactoryBean factoryBean = context.getBean("&shaDigest"
                , MessageDigestFactoryBean.class);
        try {
            MessageDigest shaDigest = factoryBean.getObject();
            System.out.println(shaDigest.digest("Hello world".getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        context.close();

    }



}
