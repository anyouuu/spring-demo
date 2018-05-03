package com.example.controller;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class hello {

    @RequestMapping("/s")
    @ResponseBody
    String homes() {
        return "Hello Worldssss!";
    }

    @RequestMapping("/ba")
    @ResponseBody
    String home() {
        return "Hello!";
    }

}

