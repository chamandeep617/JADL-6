package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllerr {

    @GetMapping("/hi")
    public String getString(){
        return "HI CHAMAN";
    }
}
