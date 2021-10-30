package com.example.helloworldspring.ch2.decoupled;

// Реализация средства воспроизведения
public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if(messageProvider == null){
            throw  new RuntimeException("You must set the "+
                    "property messageProvider of class:"+
                    StandardOutMessageRenderer.class.getName());
            // Установите свойство messageProvider в данном классе
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
