package com.example.demo.respository;

import com.example.demo.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository {

    HashMap<Integer, User> db = new HashMap<>();

    public String saveUser(User user){
        if(db.containsKey(user.getId())){
            return "Please enter the unique id";
        }
        db.put(user.getId(),user);
        return "User saved successfully";
    }


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        for(int id : db.keySet()){
            users.add(db.get(id));
        }

        return users;

    }
}
