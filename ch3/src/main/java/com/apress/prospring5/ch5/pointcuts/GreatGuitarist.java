package com.apress.prospring5.ch5.pointcuts;

public class GreatGuitarist implements Singer {

    @Override
    public void sing() {
        System.out.println("I shot the sheriff, \n"
                +"But I did not shoot the deputy");
    }
}
