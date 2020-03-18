package com.apress.prospring5;


import com.apress.prospring5.ch3.decoupled.HelloWorldConfiguration;
import com.apress.prospring5.ch3.decoupled.MessageProvider;
import com.apress.prospring5.ch3.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class App
{
    public static void main( String[] args )   {

        System.out.println( "Hello World!" );

        ApplicationContext context=new ClassPathXmlApplicationContext(
                "app-context-xml.xml");

//        ApplicationContext context= new AnnotationConfigApplicationContext(
//                HelloWorldConfiguration.class);
        //MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        //renderer.render();

        MessageProvider provider = context.getBean("provider", MessageProvider.class);
        System.out.println(provider.getMessage());
    }
}
