package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wyb on 2018/8/11.
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("/world")
    public Object helloWorld() {
        return "Hello World";
    }

}
