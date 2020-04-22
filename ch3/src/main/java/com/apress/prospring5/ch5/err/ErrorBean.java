package com.apress.prospring5.ch5.err;

public class ErrorBean {

    public void errorProneMethod() throws Exception{
        throw new Exception("Generic Exception");
    }

    public void otherProneMethod(){
        throw new IllegalArgumentException("IllegalArgument Exception");
    }
}
