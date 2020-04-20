package com.apress.prospring5.ch5;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, Object o)
            throws Throwable {
        UserInfo user=securityManager.getLoggedOnUser();
        if(user==null){
            throw new SecurityException("authentications data is wrong....");
        }

        if(user.getUserName().equals("John")
                && user.getPassword().equals("123")){
//            if(o instanceof SecureBean){
//                ((SecureBean) o).writeSecuresMessage();
//            }
        }else{
            throw new SecurityException("authentications data is wrong....");
        }
    }
}
