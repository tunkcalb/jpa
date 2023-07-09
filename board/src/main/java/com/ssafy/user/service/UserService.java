package com.ssafy.user.service;

import com.ssafy.user.dto.UserDto;

public interface UserService {
    UserDto joinUser(String userName, String password) throws Exception;

    boolean login(String userName, String password);
}
