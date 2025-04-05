package com.tmys.springfirstapp.services;

import com.tmys.springfirstapp.model.User;

public interface UserService {
    void saveUser(User user);
    User authenticate(String usernameOrEmail, String password);
}