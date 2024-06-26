package com.ms.user.controller.doc;

import com.ms.user.dto.UserDTO;
import com.ms.user.model.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User",description = "API exposed for management all user")
@RequestMapping("/api/v1/user")
public interface UserDoc {

    @Operation(summary = "create user" ,description = "this operation is for creating user")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201" , description = "user created",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "500" , description = "internal server error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "404" , description = "endpoint not found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    @PostMapping
    ResponseEntity<UserEntity> create(@Valid @RequestBody UserDTO userDTO);

    @Operation(summary = "create user" ,description = "this operation is for creating user with User Entity")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201" , description = "user created",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "500" , description = "internal server error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "404" , description = "endpoint not found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    @PostMapping("/save")
    ResponseEntity<UserEntity> createForm2(@Valid @RequestBody UserEntity userEntity);

    @Operation(summary = "get  user by id" ,description = "this operation is for getting user by id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200" , description = "user found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "500" , description = "internal server error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "404" , description = "endpoint not found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    @GetMapping("/{id}")
    ResponseEntity<UserEntity> getById(@PathVariable String id);

    @Operation(summary = "get all users" ,description = "this operation is for getting  all user")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200" , description = "user found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "500" , description = "internal server error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "404" , description = "endpoint not found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    @GetMapping()
    ResponseEntity<List<UserEntity>> listUsers();

    @Operation(summary = "get  user by document" ,description = "this operation is for getting user by document")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200" , description = "user found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "500" , description = "internal server error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "404" , description = "endpoint not found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    @GetMapping("/document/{document}")
    ResponseEntity<UserEntity> getByDocument(@PathVariable String document);

    @Operation(summary = "delete  user by id" ,description = "this operation is for delete user by id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200" , description = "user found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "500" , description = "internal server error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "404" , description = "endpoint not found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteById(@PathVariable String id);

    @Operation(summary = "update  user by id" ,description = "this operation is for update user by id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200" , description = "user found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "500" , description = "internal server error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "404" , description = "endpoint not found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    @PutMapping("/{id}")
    ResponseEntity<UserEntity> updateById(@PathVariable String id,  @RequestBody UserDTO userDTO);

    @Operation(summary = "update  user by id" ,description = "this operation is for update user by id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200" , description = "user found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "500" , description = "internal server error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "404" , description = "endpoint not found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    @PutMapping("/document/{document}")
    ResponseEntity<UserEntity> updateByDocument(@PathVariable String document,@Valid @RequestBody UserDTO userDTO);
}
