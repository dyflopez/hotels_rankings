package com.ms.ranking.controller.v1.doc;

import com.ms.ranking.dto.RankingDTO;
import com.ms.ranking.model.RankingDocument;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ranking controller" ,description = "API exposed for CRUD operations on Ranking")
@RequestMapping("/api/v1/ranking")
public interface IRankingDoc {
    @Operation(summary = "create ranking"
            ,description = "This operation is for creating ranking")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Hotel ranking",
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
    ResponseEntity<RankingDocument> create(@RequestBody RankingDTO rankingDTO);

    @Operation(summary = "getting ranking"
            ,description = "This operation is for creating ranking")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "ranking",
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
    ResponseEntity<List<RankingDocument>> listAll();

    @Operation(summary = "getting ranking by hotel ID"
            ,description = "This operation is for getting  ranking by hotel ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "ranking",
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
    @GetMapping("/find-by-hotel-id/{hotelId}")
    ResponseEntity<List<RankingDocument>> listByHotelId(@PathVariable("hotelId")  String hotelId);



    @Operation(summary = "getting ranking by hotel ID"
            ,description = "This operation is for getting  ranking by hotel ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "ranking",
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
    @GetMapping("/find-by-user-id/{userId}")
    ResponseEntity<List<RankingDocument>> listByUserID(@PathVariable("userId")  String userId);
}
