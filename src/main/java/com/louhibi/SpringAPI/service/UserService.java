package com.louhibi.SpringAPI.service;

import com.louhibi.SpringAPI.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();

        User user1 = new User(1, "Mouad1", 24, "mouad1@gmail.com");
        User user2 = new User(2, "Mouad2", 24, "mouad2@gmail.com");
        User user3 = new User(3, "Mouad3", 24, "mouad3@gmail.com");
        User user4 = new User(4, "Mouad4", 24, "mouad4@gmail.com");
        User user5 = new User(5, "Mouad5", 24, "mouad5@gmail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
    }
    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for (User user: userList) {
            if(id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
