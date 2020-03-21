package com.apress.prospring5.ch3.annotated.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class AbstractLookupDemoBean implements DemoBean {

    private SingerProtoType mySinger;

    @Override
    @Lookup("singerProtoType")
    public SingerProtoType getMySinger() {
        return null;
    }

//    @Autowired
//    public void setMySinger(SingerProtoType mySinger) {
//        this.mySinger = mySinger;
//    }

    @Override
    public void doSomething() {
        mySinger.sing();
    }
}
