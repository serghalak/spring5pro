package com.apress.prospring5.ch3.decoupled;

public class StandardOutMessageRenderer implements MessageRenderer{

    private MessageProvider messageProvider;

    @Override
    public void render() {
        if(messageProvider==null){
            throw new RuntimeException("You must set the "+
                    "property messageProvider of class:"+
                    StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider=provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
