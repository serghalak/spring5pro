package com.apress.prospring5.ch3.decoupled;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@ComponentScan(basePackages = "com.apress.prospring5")
@ImportResource(locations = "classpath:app-context-xml.xml")
public class HelloWorldConfiguration {

//    @Bean
//    public MessageProvider provider(){
//        return new HelloWorldMessageProvider();
//    }
//
//    @Bean
//    public MessageRenderer renderer(){
//        MessageRenderer messageRenderer=new StandardOutMessageRenderer();
//        messageRenderer.setMessageProvider(provider());
//        return messageRenderer;
//    }
}
