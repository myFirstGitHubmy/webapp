package com.sp.services;

import com.sp.entities.User;
import com.sp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.getOne(id);
    }

    public void deleteUserById(long id){
        userRepository.deleteById(id);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
