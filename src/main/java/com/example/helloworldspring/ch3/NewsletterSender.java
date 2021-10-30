package com.example.helloworldspring.ch3;

public interface NewsletterSender {
    // пример пассивной зависимости
    void setSmtpServer(String smtpServer);
    String getSmtpServer();
    void setFromAddress(String fromAddress);
    String getFromAddress();
    void send();
}
