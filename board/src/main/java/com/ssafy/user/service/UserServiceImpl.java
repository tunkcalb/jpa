package com.ssafy.user.service;

import com.ssafy.user.dto.User;
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
    public User joinUser(User user) throws Exception {
        return repository.save(user);
    }

    @Override
    public boolean login(User user) {
        Optional<User> findUser = repository.findById(user.getUsername());
        if(!user.getUsername().equals(findUser.get().getUsername())){
            return false;
        }
        else if (!user.getPassword().equals(findUser.get().getPassword())){
            return false;
        }
        return true;
    }
}
