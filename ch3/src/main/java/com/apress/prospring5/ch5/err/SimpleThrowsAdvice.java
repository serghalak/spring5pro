package com.apress.prospring5.ch5.err;

import com.apress.prospring5.ch5.SimpleAfterReturningAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleThrowsAdvice implements ThrowsAdvice {


    public static void main(String[] args) {
        ErrorBean errorBean=new ErrorBean();
        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.setTarget(errorBean);
        proxyFactory.addAdvice(new SimpleAfterReturningAdvice());
        ErrorBean proxy =(ErrorBean) proxyFactory.getProxy();

        try {
            proxy.errorProneMethod();
        }catch (Exception ex){

        }
        try {
            proxy.otherProneMethod();
        }catch (Exception ex){

        }

    }

    public void afterThrowing(Exception ex) throws Throwable{
        System.out.println("***");
        System.out.println("Generic Exception Capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("****\n");
    }

    public void afterThrowing(Method method
            , Object[] args
            ,Object target, IllegalArgumentException ex) throws Throwable{
        System.out.println("***");
        System.out.println("IllegalArgumentException Capture");
        System.out.println("Caught: " +ex.getClass().getName());
        System.out.println("Method: " + method.getName());
        System.out.println("***\n");
    }

}

