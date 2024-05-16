package com.documentitos.services;

import com.documentitos.models.usuario;
import com.documentitos.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class UserService {

    @Autowired
    public UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<usuario> getAllUsers() {
        return userRepository.findAll();
    }
}
