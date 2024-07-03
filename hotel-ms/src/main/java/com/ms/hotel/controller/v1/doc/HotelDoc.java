package com.ms.hotel.controller.v1.doc;


import com.ms.hotel.dto.HotelDto;
import com.ms.hotel.model.HotelEntity;
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
import java.util.UUID;

@Tag(name = "Hotel" , description = "API exposed for management all Hotel")
@RequestMapping("/api/v1/hotel")
public interface HotelDoc {

    @Operation(summary = "create Hotel"
            ,description = "This operation is for creating Hotel")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Hotel Created",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "endpoint not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    })
    @PostMapping
    ResponseEntity<HotelEntity> create(@Valid @RequestBody HotelDto hotelDTO);

    @Operation(summary = "get Hotel"
            ,description = "This operation is for getting Hotels")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Hotel founded",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "endpoint not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    })
    @GetMapping
    ResponseEntity<List<HotelEntity>> getAll();

    @Operation(summary = "get Hotel by Id"
            ,description = "This operation is for getting")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Hotel founded",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "endpoint not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    })
    @GetMapping("/{id}")
    ResponseEntity<HotelEntity> getById(@PathVariable("id") UUID id);
}
