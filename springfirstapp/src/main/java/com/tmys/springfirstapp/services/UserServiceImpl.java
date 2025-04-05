package com.tmys.springfirstapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import com.tmys.springfirstapp.Repository.UserRepository;
import com.tmys.springfirstapp.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User authenticate(String usernameOrEmail, String password) {
        Optional<User> userOpt = userRepo.findByEmail(usernameOrEmail);
        if (userOpt.isEmpty()) {
            userOpt = userRepo.findByUsername(usernameOrEmail);
        }

        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            return userOpt.get();
        }
        return null;
    }
}
