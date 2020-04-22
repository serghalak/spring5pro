package com.apress.prospring5.ch5;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceDemo {

    private static KeyGenerator getKeyGenerator(){
        KeyGenerator target=new KeyGenerator();
        ProxyFactory pf=new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvice(new WeakKeyCheckAdvice());
        KeyGenerator proxy = (KeyGenerator) pf.getProxy();
        return proxy;
    }

    public static void main(String[] args) {
        KeyGenerator keyGen=getKeyGenerator();
        long key = keyGen.getKey();
    }
}
