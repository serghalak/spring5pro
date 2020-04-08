package com.apress.prospring5.ch4.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;


@Configuration
@PropertySource("classpath:message.properties")
public class JavaConfigDemo {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        ApplicationContext ctx=
                new AnnotationConfigApplicationContext(JavaConfigDemo.class);
        MessageRenderer messageRenderer =
                ctx.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();
    }


    @Bean
    @Lazy
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean
    @Scope(value="prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer =
                new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());

        return messageRenderer;
    }
}
