package com.apress.prospring5.ch3.annotated.dependon;

import org.springframework.stereotype.Component;

@Component
public class Guitar {
    public void sing(){
        System.out.println("Cm Eb Fm Ab Bb");
    }
}
