package com.apress.prospring5.ch5.pointcuts;



public class GoodGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("who says I can't be free \n"+
                "From all of the things that I used to be");
    }
}
