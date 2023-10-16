package com.playground.user.service;

import com.beehive.lib.Service.Service;
import com.beehive.annotations.Injectable;
import com.playground.user.entity.UserEntity;

import com.playground.user.repository.UserRepository;

@Injectable
public class UserService extends Service {
    private final UserRepository userRepository = repository(UserRepository.class);

    public void create(String name, String username, String email, String passwordHash) {
        UserEntity user = new UserEntity();

        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPasswordHash(passwordHash);

        userRepository.save(user);
    }

    public String getUserPasswordHashByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        return user.getPasswordHash();
    }
}
