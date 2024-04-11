package org.example.mongorestapi.service;

import org.example.mongorestapi.collection.User;
import org.example.mongorestapi.dto.auth.LoginDto;

public interface UserService {

    User addUser ( User user) throws Exception;
    User login (LoginDto user) throws Exception;
    String validEmail (String email) throws Exception;
    Object getUsers();
    Object getUserById(String id);
    String updateUser(String id, User user);
    void deleteUser(String id);

}
