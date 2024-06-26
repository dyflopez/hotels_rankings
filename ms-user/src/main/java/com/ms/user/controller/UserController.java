package com.ms.user.controller;

import com.ms.user.configs.ExceptionConfigs;
import com.ms.user.controller.doc.UserDoc;
import com.ms.user.dto.UserDTO;
import com.ms.user.model.UserEntity;
import com.ms.user.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class UserController implements UserDoc {

    private final IUserService iUserService;

    @Override
    public ResponseEntity<UserEntity> create(UserDTO userDTO) {

        log.info(
                 " create()  \n {}",userDTO
        );
        return this.iUserService.save(userDTO);
    }
    @Override
    public ResponseEntity<UserEntity> createForm2(UserEntity userEntity) {

        return ResponseEntity
                .ok(
                        userEntity
                );
    }

    @Override
    public ResponseEntity<UserEntity> getById(String id) {
        return this.iUserService.getById(id);
    }

    @Override
    public ResponseEntity<List<UserEntity>> listUsers() {
        return this.iUserService.getAll();
    }

    @Override
    public ResponseEntity<UserEntity> getByDocument(String document) {
        //TODO Crear  getByDocument
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(String id) {
        return this.iUserService.deleteById(id);
    }

    @Override
    public ResponseEntity<UserEntity> updateById(String id, UserDTO userDTO) {
        return this.iUserService.updateUserById(id,userDTO);
    }

    @Override
    public ResponseEntity<UserEntity> updateByDocument(String document, UserDTO userDTO) {
        return this.iUserService.updateUserById(document,userDTO);
    }
}
