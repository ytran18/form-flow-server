package org.example.mongorestapi.service.impl;

import org.example.mongorestapi.collection.User;
import org.example.mongorestapi.dto.auth.LoginDto;
import org.example.mongorestapi.repository.UserRepository;
import org.example.mongorestapi.service.UserService;
import org.example.mongorestapi.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    // sign up
    @Override
    public User addUser(User user) throws Exception {
        Query query = new Query(Criteria.where("email").is(user.getEmail()));
        User checkExistsUser = mongoTemplate.findOne(query, User.class);
        if (checkExistsUser == null) {
            userRepository.insert(user);
            return user;
        } else {
            throw new Exception(Constant.USER_EXIST);
        }
    };

    // check email before login
    @Override
    public String validEmail(String email) throws Exception {
        Query query = new Query(Criteria.where("email").is(email));
        User checkExistsUser = mongoTemplate.findOne(query, User.class);
        if (checkExistsUser != null) {
            return "User exist";
        } else {
            throw new Exception(Constant.USER_NOT_FOUND);
        }
    };

    // login
    @Override
    public User login(LoginDto user) throws Exception {
        Query query = new Query(Criteria.where("email").is(user.getEmail()).and("password").is(user.getPassword()));
        User checkExistsUser = mongoTemplate.findOne(query, User.class);
        if (checkExistsUser == null) throw new Exception(Constant.AUTH_FAIL);

        return checkExistsUser;
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