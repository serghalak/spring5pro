package com.apress.prospring5.ch3.annotated.dependon;

import com.apress.prospring5.ch3.xml.Guitar;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn(value = "guitar")
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
