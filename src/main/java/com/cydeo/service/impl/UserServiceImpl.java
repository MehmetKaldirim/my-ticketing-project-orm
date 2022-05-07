package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {

        List<User> userList = userRepository.findAll();
        return userList.stream().map(userMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        User user =userRepository.findByUserName(username);

        return userMapper.convertToDto(user);
    }

    @Override
    public void save(UserDTO dto) {
        User addUser = userMapper.convertToEntity(dto);
        userRepository.save(addUser);
    }

    @Override
    public void update(UserDTO dto) {

        //Find current user
        User addUser = userRepository.findByUserName((dto.getUserName()));
        //Find updated dto to entity object
        User converterUser = userMapper.convertToEntity(dto);
        //set id to converted object
        converterUser.setId(addUser.getId());
        //save updated user
        userRepository.save(converterUser);
    }




    @Override
    public void deleteByUserName(String username) {
        userRepository.deleteByUserName(username);
    }

    @Override
    public void delete(String username) {
        //change flag not delete data
        User user =userRepository.findByUserName(username);
        user.setIsDeleted(true);
        userRepository.save(user);
    }
}
