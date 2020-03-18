package com.apress.prospring5.ch3.decoupled;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    @Autowired
    public ConfigurableMessageProvider(/*@Value("Configurable message")*/
                                                   String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
