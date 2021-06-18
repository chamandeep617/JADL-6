package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PutMapping("/saveUser")
    public String saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getUser(){
        return userService.getAllUsers();
    }
}