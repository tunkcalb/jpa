package com.ssafy.user.service;

import com.ssafy.user.dto.UserDto;
import com.ssafy.user.entity.User;
import com.ssafy.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    public UserServiceImpl(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public UserDto joinUser(String userName, String password) throws Exception {
        User user = new User(userName, password);
        User saveUser = repository.save(user);
        UserDto userDto = new UserDto(saveUser.getUserName(), saveUser.getPassword());
        return userDto;
    }

    @Override
    public boolean login(String userName, String password) {
        User findUser = repository.findByUserName(userName);
        if(!findUser.getUserName().equals(userName)){
            return false;
        }
        else if (!findUser.getPassword().equals(password)){
            return false;
        }
        return true;
    }
}
