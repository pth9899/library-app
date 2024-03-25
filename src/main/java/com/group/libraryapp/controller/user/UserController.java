package com.group.libraryapp.controller.user;


import com.group.libraryapp.dto.user.response.UserCreateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.dto.user.response.UserUpdateRequest;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final JdbcTemplate jdbcTemplate;
    private UserServiceV2 userService;
    public UserController(JdbcTemplate jdbcTemplate, UserServiceV2 userService) {
        this.jdbcTemplate = jdbcTemplate;
        this.userService = userService;
    }
   @PostMapping("/user")
   public void saveUser(@RequestBody UserCreateRequest request){
        userService.saveUser(request);
   }
    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        userService.updateUser(request);
    }
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }
}