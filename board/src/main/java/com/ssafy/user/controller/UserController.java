package com.ssafy.user.controller;

import com.ssafy.user.dto.User;
import com.ssafy.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/join")
    public void join(@RequestBody User userDto) {
        logger.debug("userDto info : {}", userDto);
        try {
            userService.joinUser(userDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
