package com.apress.prospring5.ch3;

import com.apress.prospring5.ch3.DemoBean;
import com.apress.prospring5.ch3.Singer;

public class StandardLookupDemoBean implements DemoBean {

    private Singer mySinger;

    @Override
    public Singer getMySinger() {
        return mySinger;
    }

    public void setMySinger(Singer mySinger) {
        this.mySinger = mySinger;
    }

    @Override
    public void doSomething() {
        mySinger.sing();
    }
}
