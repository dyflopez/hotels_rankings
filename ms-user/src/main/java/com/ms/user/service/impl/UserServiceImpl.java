package com.ms.user.service.impl;

import com.ms.user.dto.UserDTO;
import com.ms.user.exception.MyHandleException;
import com.ms.user.model.UserEntity;
import com.ms.user.repository.UserRepository;
import com.ms.user.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<UserEntity> save(UserDTO userDTO) {

        log.info(
                " ingresa a  a save() {}",userDTO
        );

        log.warn(
                " buscar usuario por documento  "
        );
        var currentUser = this.userRepository.findByDocument(userDTO.getDocument());
        log.info(
                " Validar si existe el usuario  "
        );
        if(currentUser.isPresent()){
            throw new MyHandleException("user already exist in database");
        }

        UserEntity use =   UserEntity
                .builder()
                .id(UUID.randomUUID().toString())
                .document(userDTO.getDocument())
                .name(userDTO.getName())
                .information(userDTO.getInformation())
                .email(userDTO.getEmail())
                .build();

        var newUser =  this.userRepository.save(use);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newUser);
    }



    @Override
    public ResponseEntity<UserEntity> updateUserByDocument(String document, UserDTO userDTO) {

        var user =  this
                .userRepository
                .findByDocument(document)
                .orElseThrow(()-> new MyHandleException("User does not exist "));

        user.setDocument(userDTO.getDocument());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setInformation(userDTO.getInformation());
        var updatedUSer= this.userRepository.save(user);

        return ResponseEntity.ok(updatedUSer);
    }

    @Override
    public ResponseEntity<?> deleteById(String id) {
        this.userRepository.deleteById(id);
        return ResponseEntity
                .ok()
                .build();
    }

    @Override
    public ResponseEntity<List<UserEntity>> getAll() {
        var users = this.userRepository.findAll();
        return ResponseEntity
                .ok(users);
    }

    @Override
    public ResponseEntity<UserEntity> getById(String id) {

        //TODO Realizar validacion  de que no existe el usuario
        var user  = this.userRepository
                    .findById(id)
                    .orElseThrow(()-> new MyHandleException("User does not exist "));

        return ResponseEntity
                .ok(user);
    }

    @Override
    public ResponseEntity<UserEntity> updateUserById(String id, UserDTO userDTO) {

        //TODO validaciones y refactorizar
        var userResponse =  this.userRepository.findById(id);
        if(userResponse.isPresent()){
            UserEntity currentUser =  userResponse.get();

            currentUser.setDocument(userDTO.getDocument());
            currentUser.setName(userDTO.getName());
            currentUser.setEmail(userDTO.getEmail());
            currentUser.setInformation(userDTO.getInformation());
            var updatedUSer= this.userRepository.save(currentUser);

            return ResponseEntity.ok(updatedUSer);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new UserEntity());
    }
}
