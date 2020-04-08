package com.apress.prospring5.ch4;

import org.springframework.context.ApplicationListener;

public class MessageEventListener
        implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        MessageEvent msgEvt=(MessageEvent)messageEvent;
        System.out.println("Received: " + msgEvt.getMsg());
    }
}
