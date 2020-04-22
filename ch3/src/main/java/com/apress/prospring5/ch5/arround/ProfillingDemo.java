package com.apress.prospring5.ch5.arround;

import org.springframework.aop.framework.ProxyFactory;

public class ProfillingDemo {

    public static void main(String[] args) {
        WorkerBean workerBean=new WorkerBean();
        ProfilingInterceptor profilingInterceptor=new ProfilingInterceptor();
        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.addAdvice(profilingInterceptor);
        proxyFactory.setTarget(workerBean);
        WorkerBean proxy = (WorkerBean) proxyFactory.getProxy();
        proxy.doSomeWork(10000000);
    }


}
