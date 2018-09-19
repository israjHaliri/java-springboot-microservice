package com.haliri.israj.appaccount.service;

import com.haliri.israj.appaccount.repository.UserRepository;
import com.haliri.israj.appcommon.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> find(){
        return userRepository.find(null, null, null);
    }

    @Transactional
    public void save(User user){
       userRepository.save(user);
    }

    @Transactional
    public void updateBill(User user){
        userRepository.updateBill(user);
    }
}
