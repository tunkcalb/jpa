package com.ssafy.user.controller;

import com.ssafy.user.dto.User;
import com.ssafy.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/")
    public boolean root() {
        return true;
    }

    @PostMapping("/join")
    public boolean join(@RequestBody User user) {
        logger.debug("userDto info : {}", user);
        try {
            userService.joinUser(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        return userService.login(user);
    }
}
