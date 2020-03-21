package com.apress.prospring5.ch3.annotated.lookup;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SingerProtoType {
    private String lyric="I played a quik game of chess "
            +"with the salt and pepper shaker";

    public void sing(){
        System.out.println(lyric);
    }
}
