package com.bstirbat.sample.electronicstore.controller;

import com.bstirbat.sample.electronicstore.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public String hello() {
        return messageService.hello();
    }
}
