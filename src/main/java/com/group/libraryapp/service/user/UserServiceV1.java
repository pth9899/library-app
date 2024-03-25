package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.response.UserCreateRequest;
import com.group.libraryapp.dto.user.response.UserJdbcRepository;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.dto.user.response.UserUpdateRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

    private UserJdbcRepository userJdbcRepository;

    public UserServiceV1(JdbcTemplate jdbcTemplate) {
        this.userJdbcRepository = new UserJdbcRepository(jdbcTemplate);
    }

    public void updateUser(JdbcTemplate jdbcTemplate, UserUpdateRequest request){
        if(userJdbcRepository.isUserNotExist(jdbcTemplate, request.getId())){
            throw new IllegalArgumentException();
        }
        userJdbcRepository.updateUser(jdbcTemplate, request.getName(), request.getId());
    }

    public void deleteUser(String name){
        if(userJdbcRepository.isUserNotExist(name)){
            throw new IllegalArgumentException();
        }
    userJdbcRepository.deleteUser(name);
    }

    public List<UserResponse> getUser(){
        return userJdbcRepository.getUserResponses();
    }


}