package com.lgdx.RobotEducationBackend.service;

import com.lgdx.RobotEducationBackend.domain.User;
import com.lgdx.RobotEducationBackend.dto.UserDTO;
import com.lgdx.RobotEducationBackend.repository.UserRepository;
import com.lgdx.RobotEducationBackend.exception.ListNotFoundElementException;
import com.lgdx.RobotEducationBackend.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    @Transactional
    public UserDTO getOneUser(String userId) {
        return UserDTO.from(userRepository.findByUserId(userId).orElseThrow(ResourceNotFoundException::new));
    }

//    @Transactional
//    public List<UserDTO> getAllMember() {
//        List<User> Users = userRepository.findAll();
//
//        if (Users.isEmpty()) {
//            throw new ListNotFoundElementException();
//        }
//
//        List<UserDTO> userDTOS = new ArrayList<>();
//        for (User user : users) {
//            userDTOS.add(UserDTO.from(user));
//        }
//
//        return userDTOS;
//    }
}