package com.ssafy.user.service;

import com.ssafy.user.dto.User;

import java.util.Optional;

public interface UserService {
    User joinUser(User userDto) throws Exception;

    boolean login(User user);
}
