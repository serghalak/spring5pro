package com.apress.prospring5.ch5;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(
            Object o
            , Method method
            , Object[] objects
            , Object o1) throws Throwable {

        if((o1 instanceof KeyGenerator) && method.getName().equals("getKey") ){
            if(o instanceof Long){
                Long key = (Long) o;
                if(key==KeyGenerator.WEAK_KEY){
                    System.out.println("key is weak");
                throw new SecurityException(
                        "Key Generator generated a weak key. Try again");
                }
                System.out.println("key is good");
            }
        }


    }
}
