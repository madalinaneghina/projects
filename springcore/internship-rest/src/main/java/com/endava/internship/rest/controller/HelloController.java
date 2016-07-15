package com.endava.internship.rest.controller;

import com.endava.internship.rest.model.HelloMessage;
import com.endava.internship.rest.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<Resource<HelloMessage>> hello(@RequestParam("greeting") String greeting) {
        HelloMessage helloMessage = this.helloService.getHelloMessage(greeting);

        Resource<HelloMessage> helloMessageResource = new Resource<>(helloMessage);
        helloMessageResource.add(linkTo(methodOn(HelloController.class).hello(greeting)).withSelfRel());

        return new ResponseEntity<>(helloMessageResource, HttpStatus.OK);
    }

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public HttpEntity<Resource<HelloMessage>> helloUser(@PathVariable("name") String providedName) {
        HelloMessage helloMessageForUser = this.helloService.getHelloMessageForUser(providedName);

        Resource<HelloMessage> helloMessageResource = new Resource<>(helloMessageForUser);
        helloMessageResource.add(linkTo(methodOn(HelloController.class).helloUser(providedName)).withSelfRel());

        return new ResponseEntity<>(helloMessageResource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Resource<HelloMessage>> createGreeting(@RequestBody HelloMessage message) {
        HelloMessage createdMessage = this.helloService.createMessage(message);

        Resource<HelloMessage> helloMessageResource = new Resource<>(createdMessage);
        helloMessageResource.add(linkTo(methodOn(HelloController.class).hello(createdMessage.getMessage())).withSelfRel());

        return new ResponseEntity<>(helloMessageResource, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/broken", method = RequestMethod.GET)
    public HttpEntity<Resource<HelloMessage>> brokenHello() {
        throw new NullPointerException();
    }
}

