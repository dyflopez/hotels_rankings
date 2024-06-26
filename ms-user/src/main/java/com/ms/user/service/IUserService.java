package com.ms.user.service;

import com.ms.user.dto.UserDTO;
import com.ms.user.model.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    ResponseEntity<UserEntity> save(UserDTO userDTO);
    ResponseEntity<UserEntity> updateUserById(String id,UserDTO userDTO);
    ResponseEntity<UserEntity> updateUserByDocument(String document,UserDTO userDTO);

    ResponseEntity<?>  deleteById(String id);

    ResponseEntity<List<UserEntity>> getAll();

    ResponseEntity<UserEntity> getById(String id);
}
