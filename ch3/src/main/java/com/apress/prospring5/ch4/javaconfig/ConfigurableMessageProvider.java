package com.apress.prospring5.ch4.javaconfig;

import com.apress.prospring5.ch3.decoupled.MessageProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    public ConfigurableMessageProvider(
            @Value("Love on the  weekend") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
