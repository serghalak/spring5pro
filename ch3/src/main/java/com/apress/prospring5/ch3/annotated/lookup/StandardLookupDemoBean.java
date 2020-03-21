package com.apress.prospring5.ch3.annotated.lookup;

import com.apress.prospring5.ch3.annotated.lookup.DemoBean;
import com.apress.prospring5.ch3.annotated.lookup.SingerProtoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StandardLookupDemoBean implements DemoBean {
    private SingerProtoType mySinger;

    @Override
    public SingerProtoType getMySinger() {
        return mySinger;
    }

    @Autowired
    public void setMySinger(SingerProtoType mySinger) {
        this.mySinger = mySinger;
    }

    @Override
    public void doSomething() {
        mySinger.sing();
    }
}
