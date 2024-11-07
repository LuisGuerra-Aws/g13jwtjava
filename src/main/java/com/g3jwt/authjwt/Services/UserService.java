package com.g3jwt.authjwt.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3jwt.authjwt.Entities.User;
import com.g3jwt.authjwt.Repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        users = (List<User>) userRepository.findAll();
//        return (List<User>) userRepository.findAll();
//        userRepository.findAll().forEach(users::add);
        return users;
    }

    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

}
