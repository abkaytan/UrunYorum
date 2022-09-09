package com.urun.controller;


import com.urun.dto.UserDto;
import com.urun.entity.User;
import com.urun.service.Impl.UserServiceImpl;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @PostMapping("/save-user")
    public ResponseEntity<User> saveUser(@RequestBody UserDto userDto){
        User user = userServiceImpl.saveUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
