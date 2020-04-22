package com.apress.prospring5.ch5.pointcuts;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.w3c.dom.ls.LSInput;

public class StaticPointDemo {

    public static void main(String[] args) {
        GoodGuitarist johnMayer=new GoodGuitarist();
        GreatGuitarist ericClapton=new GreatGuitarist();
        Singer proxyOne;
        Singer proxyTwo;
        Pointcut pointcut=new SimpleStaticPointcut();
        Advice  advice=new SimpleAdvise();
        Advisor advisor=new DefaultPointcutAdvisor(pointcut,advice);
        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(johnMayer);
        proxyOne=(Singer)proxyFactory.getProxy();

        proxyFactory=new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(ericClapton);
        proxyTwo=(Singer)proxyFactory.getProxy();
        proxyOne.sing();
        proxyTwo.sing();
    }
}
