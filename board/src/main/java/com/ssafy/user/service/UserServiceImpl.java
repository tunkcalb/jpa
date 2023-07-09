package com.ssafy.user.service;

import com.ssafy.user.dao.UserDao;
import com.ssafy.user.dto.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public int joinUser(User userDto) throws Exception {
        return userDao.joinUser(userDto);
    }
}
