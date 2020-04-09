package com.apress.prospring5.ch4.javaconfig;

import com.apress.prospring5.ch3.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


public class JavaConfigExampleTwo {

    public static void main(String[] args) {
        ApplicationContext ctx=
                new AnnotationConfigApplicationContext(AppConfigTwo.class);
        MessageRenderer renderer=ctx.getBean(
                "messageRenderer", MessageRenderer.class);
        renderer.render();
    }
}
