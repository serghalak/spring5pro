package com.apress.prospring5.ch5;

import com.apress.prospring5.ch3.xml.Guitar;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {

    public static void main(String[] args) {
        Guitarist guitarist=new Guitarist();
        ProxyFactory pf=new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(guitarist);
        Guitarist proxy =(Guitarist) pf.getProxy();
        proxy.sing();
    }
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before '" + method.getName()+"', tune guitar.");
    }
}
