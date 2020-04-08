package com.apress.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

public class MessageSourceDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch4/app-context-xml.xml");
        ctx.refresh();

        Locale english=Locale.ENGLISH;
        Locale german=new Locale("de","DE");
        System.out.println(ctx.getMessage("msg",null,english));
        System.out.println(ctx.getMessage("msg",null,german));
        System.out.println(ctx.getMessage("nameMsg"
                ,new Object[]{"John","Mayer"},english));
        System.out.println(ctx.getMessage("nameMsg"
                ,new Object[]{"John","Mayer"},german));
        ctx.close();
    }

}
