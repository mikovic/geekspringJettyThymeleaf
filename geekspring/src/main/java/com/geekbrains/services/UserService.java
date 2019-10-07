package com.geekbrains.services;

import com.geekbrains.entities.User;
import com.geekbrains.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Query("SELECT user From User user left join fetch user.roles  WHERE user.email =:email")
    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
