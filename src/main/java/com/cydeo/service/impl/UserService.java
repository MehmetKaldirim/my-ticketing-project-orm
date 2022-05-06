package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements com.cydeo.service.UserService {
    @Override
    public List<UserDTO> listAllUsers() {
        //c
        return null;
    }

    @Override
    public UserDTO findByUserName(String username) {
        return null;
    }

    @Override
    public void save(UserDTO dto) {

    }

    @Override
    public UserDTO update(UserDTO dto) {
        return null;
    }

    @Override
    public void deleteByUserName(String username) {

    }
}
