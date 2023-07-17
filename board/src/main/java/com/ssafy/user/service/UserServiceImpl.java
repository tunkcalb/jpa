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
    public UserDto joinUser(String username, String password) throws Exception {
        User user = new User(username, password);
        User saveUser = repository.save(user);
        UserDto userDto = new UserDto(saveUser.getUsername(), saveUser.getPassword());
        return userDto;
    }

    @Override
    public boolean login(String username, String password) {
        User findUser = repository.findByUsername(username);
        if(!findUser.getUsername().equals(username)){
            return false;
        }
        else if (!findUser.getPassword().equals(password)){
            return false;
        }
        return true;
    }
}
