package com.endava.internship.rest.service;

import com.endava.internship.rest.exception.ValidationException;
import com.endava.internship.rest.model.HelloMessage;
import com.endava.internship.rest.repository.HelloRepository;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloRepository repository;

    public HelloMessage getHelloMessage() {
        HelloMessage helloMessage = new HelloMessage();
        helloMessage.setMessage("HELLO");
        return helloMessage;
    }

    public HelloMessage getHelloMessage(String message) {
        HelloMessage helloMessage = new HelloMessage();
        helloMessage.setMessage(message);
        return helloMessage;
    }

    public HelloMessage getHelloMessageForUser(String user) {
        HelloMessage helloMessage = new HelloMessage();
        helloMessage.setMessage("Hello, " + user);
        return helloMessage;
    }

    public HelloMessage createMessage(HelloMessage message) {
        if (message.getMessage().trim().isEmpty()) {
            throw new ValidationException("Hello message cannot be empty");
        }

        return this.repository.createMessage(message);
    }
}
