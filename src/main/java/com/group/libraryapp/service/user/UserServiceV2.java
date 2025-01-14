package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.response.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceV2 {
    private UserRepository userRepository;
    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
   public void saveUser(UserCreateRequest request){
        userRepository.save(new User(request.getName(), request.getAge()));
   }
   @Transactional
   public List<UserResponse> getUsers(){
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
   }
   @Transactional
   public void updateUser(UserUpdateRequest request){
      User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);
      user.updateName(request.getName());
      userRepository.save(user);
    }
    @Transactional
    public void deleteUser(String name) {
        User user = userRepository.findByName(name);
        if(user==null){
            throw new IllegalArgumentException();
        }
        userRepository.delete(user);
    }
}