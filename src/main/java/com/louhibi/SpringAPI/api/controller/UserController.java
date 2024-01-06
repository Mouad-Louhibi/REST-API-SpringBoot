package com.louhibi.SpringAPI.api.controller;

import com.louhibi.SpringAPI.api.model.User;
import com.louhibi.SpringAPI.service.UserService;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/User")
    public User getUser(@RequestParam Integer id){
        Optional user = userService.getUser(id);
        if (user.isPresent()){
            return (User) user.get();
        }
        return null;
    }

    @GetMapping("/")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping("/User")
    public User postUser(@RequestBody User user){
        userService.cearteUser(user);
        return user;
    }

    @DeleteMapping("/User")
    public ResponseEntity deleteUser(@RequestParam Integer id){
        if(userService.deleteUser(id))
            return ResponseEntity.ok(HttpStatus.OK);
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }
}
