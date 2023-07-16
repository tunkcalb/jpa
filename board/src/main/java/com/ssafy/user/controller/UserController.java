package com.ssafy.user.controller;

import com.ssafy.user.dto.UserDto;
import com.ssafy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
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
    public String join(@RequestBody @Valid UserDto user) {
        String userName = user.getUsername();
        String password = user.getPassword();
        try {
            UserDto userDto = userService.joinUser(userName, password);
            return userDto.getUsername();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return "false";
    }

    @PostMapping("/login")
    public boolean login(@RequestBody UserDto user) {
        String userName = user.getUsername();
        String password = user.getPassword();
        return userService.login(userName, password);
    }
}
