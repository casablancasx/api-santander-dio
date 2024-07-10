package io.danilo.santanderdiojava.services;

import io.danilo.santanderdiojava.model.User;
import io.danilo.santanderdiojava.repositories.UserRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public User create(User user) {
       if (user.getId() != null) {
           throw new DuplicateKeyException("user already exists");
       }else{
           return userRepository.save(user);
       }
    }
}
