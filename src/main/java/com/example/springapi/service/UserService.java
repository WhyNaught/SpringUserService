package com.example.springapi.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.springapi.api.model.*;

@Service
public class UserService {
    private List<User> userList;

    public UserService() {  
        userList = new ArrayList<>(); 

        User user1 = new User(0, "a", "a", "a"); 
        User user2 = new User(1, "b", "b", "b");
        User user3 = new User(2, "c", "c", "c");
        
        userList.addAll(Arrays.asList(user1, user2, user3)); 

    }

    public Optional<User> getUser(Integer id) {
        return userList.stream().filter(user -> (user.getId() == id)).findFirst();
    }
}
 