package com.apress.prospring5.ch5;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityDemo {

    public static void main(String[] args) {
        SecurityManager mgr=new SecurityManager();
        mgr.login("John333","123");
        SecureBean secureBean=getSecurityBean();
        secureBean.writeSecuresMessage();
    }

    private static SecureBean getSecurityBean(){
        ProxyFactory proxyFactory=new ProxyFactory();
        SecurityAdvice securityAdvice=new SecurityAdvice();
        SecureBean secureBean=new SecureBean();
        proxyFactory.setTarget(secureBean);
        proxyFactory.addAdvice(securityAdvice);
        SecureBean proxy =(SecureBean) proxyFactory.getProxy();
        return proxy;
    }
}
