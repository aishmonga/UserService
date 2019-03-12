package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){

        User savedUser = userRepository.save(user);

        return savedUser;
    }

    public List<User> getALlUsers(){

        List<User> gotUser = (List<User>)userRepository.findAll();

        return gotUser;

    }

    public User getUserById(int id){

        User userById = userRepository.findById(id).get();
        return userById;

    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }


    public User updatedUser(User user, int id) {
        User userById = userRepository.findById(id).get();
        userById.setGender(user.getGender());
        return userRepository.save(userById);
    }
}
