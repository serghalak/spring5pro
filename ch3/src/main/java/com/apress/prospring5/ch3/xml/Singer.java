package com.apress.prospring5.ch3.xml;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Singer implements ApplicationContextAware {

    private ApplicationContext ctx;
    private Guitar guitar;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        ctx=applicationContext;
    }


    public void sing(){
        guitar=ctx.getBean("guitar",Guitar.class);
        guitar.sing();
    }

}
