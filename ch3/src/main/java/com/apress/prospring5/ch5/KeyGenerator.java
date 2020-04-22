package com.apress.prospring5.ch5;

import java.util.Random;

public class KeyGenerator {

    protected static final long WEAK_KEY=0xFFFFFFF0000000L;
    protected static final long STRONG_KEY=0xACDF03F590AE56L;

    private Random rnd=new Random();

    public long getKey(){
        int x=rnd.nextInt(3);

        if(x==1)
            return WEAK_KEY;

        return STRONG_KEY;
    }
}
