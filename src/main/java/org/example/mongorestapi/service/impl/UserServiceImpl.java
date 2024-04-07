package org.example.mongorestapi.service.impl;

import org.example.mongorestapi.collection.User;
import org.example.mongorestapi.repository.UserRepository;
import org.example.mongorestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private MongoTemplate mongoTemplate;

    @Override
    public String addUser(User user) {
        return userRepository.save(user).get_id();
    };

    @Override
    public Object getUsers() {
        return userRepository.findAll();
    };

    @Override
    public Object getUserById(String id) {
        return userRepository.findById(id);
    };

    @Override
    public String updateUser(String id, User user) {
        return userRepository.save(user).get_id();
    };

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    };

}