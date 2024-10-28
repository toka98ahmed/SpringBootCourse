package com.springbootdemo.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController


public class RestController {
    //expose "/" that return "hello world"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
}
