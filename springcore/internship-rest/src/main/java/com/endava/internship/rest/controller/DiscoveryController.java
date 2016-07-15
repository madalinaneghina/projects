package com.endava.internship.rest.controller;


import ch.qos.logback.core.recovery.ResilientOutputStreamBase;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/discovery", produces = MediaType.APPLICATION_JSON_VALUE)
public class DiscoveryController {

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<Resources<Object>> discovery() {

        List<Link> links = new ArrayList<>();
        links.add(linkTo(methodOn(DiscoveryController.class).discovery()).withSelfRel());
        links.add(linkTo(methodOn(HelloController.class).hello("default-user")).withRel("hello"));

        return new ResponseEntity<>(new Resources<>(Collections.emptySet(), links), HttpStatus.OK);
    }
}
