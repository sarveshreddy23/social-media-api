package com.learning.socialmediaapi.service;

import com.learning.socialmediaapi.entity.User;
import com.learning.socialmediaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findOne(int id){
        return userRepository.findById(id).orElse(null);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    public User saveUser(User user){
          return   userRepository.save(user);
    }
}
