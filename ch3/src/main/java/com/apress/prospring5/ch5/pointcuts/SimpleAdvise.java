package com.apress.prospring5.ch5.pointcuts;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvise implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(">> Invoking "
            + methodInvocation.getMethod().getName());
        Object retVal = methodInvocation.proceed();
        System.out.println(">> Done\n");
        return retVal;

    }
}
