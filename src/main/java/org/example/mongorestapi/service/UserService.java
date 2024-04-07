package org.example.mongorestapi.service;

import org.example.mongorestapi.collection.User;

public interface UserService {

    String addUser ( User user);
    Object getUsers();
    Object getUserById(String id);
    String updateUser(String id, User user);
    void deleteUser(String id);

}
