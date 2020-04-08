package com.apress.prospring5.ch4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Publisher implements ApplicationContextAware {

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(
            ApplicationContext applicationContext)
            throws BeansException {
        ctx=applicationContext;
    }

    public void publish(String message){
        ctx.publishEvent(new MessageEvent(this,message));
    }

    public static void main(String[] args) {
        ApplicationContext ctx=
            new ClassPathXmlApplicationContext(
                    "classpath:spring/ch4/app-context-xml.xml");
        Publisher pub=(Publisher)ctx.getBean("publisher");
        pub.publish("I send an SOS to the world ...");
        pub.publish("... I hope that someone gets my ...");
        pub.publish("...Message in a bootle");
    }
}
