package com.endava.internship.rest.repository;

import com.endava.internship.rest.model.HelloMessage;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HelloRepository {

    private List<HelloMessage> messages;

    @PostConstruct
    public void initialize() {
        this.messages = new ArrayList<>();

        HelloMessage message = new HelloMessage();
        message.setMessage("message 1");

        this.messages.add(message);

        message = new HelloMessage();
        message.setMessage("message 2");

        this.messages.add(message);
    }

    public HelloMessage createMessage(HelloMessage message) {
        this.messages.add(message);

        return message;
    }

}
