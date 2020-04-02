package com.apress.prospring5.ch4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;

public class MessageDigesterConfigDemo {

    @Configuration
    static class MessageDigestConfig{

        @Bean
        public MessageDigestFactoryBean digestOne(){
            MessageDigestFactoryBean factoryOne = new MessageDigestFactoryBean();
            factoryOne.setAlgorithmName("SHA1");
            return factoryOne;
        }
        @Bean
        public MessageDigestFactoryBean digestDefault(){
            return new MessageDigestFactoryBean();
        }

        @Bean
        public MessageDigester messageDigester() throws Exception {
            MessageDigester messageDigester = new MessageDigester();
            messageDigester.setDigest1(digestOne().getObject());
            messageDigester.setDigest2(digestDefault().getObject());
            return messageDigester;
        }

        public static void main(String[] args) {
            AnnotationConfigApplicationContext context=
                    new AnnotationConfigApplicationContext(
                            MessageDigestConfig.class);
            MessageDigester digester=
                    context.getBean("messageDigester",MessageDigester.class);
            digester.digest("Hello World!");
            context.close();
        }
    }
}
