package com.apress.prospring5.ch4;

import org.springframework.beans.factory.BeanNameAware;

public class NamedSinger implements BeanNameAware {

    private String name;
    @Override
    public void setBeanName(String s) {
        name=s;
    }

    public void sing(){
        System.out.println("My name is: " + name);

    }
}
