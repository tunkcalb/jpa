package com.ssafy.user.service;

import com.ssafy.user.dto.User;

public interface UserService {
    int joinUser(User userDto) throws Exception;
}
