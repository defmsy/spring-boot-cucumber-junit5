package com.example.springbootcucumberjunit5.controllers;

import com.example.springbootcucumberjunit5.services.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        return this.helloService.sayHello(name);
    }

}
