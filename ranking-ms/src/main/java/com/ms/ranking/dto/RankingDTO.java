package com.ms.ranking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankingDTO {

    private String userId;

    private String hotelId;

    private int score;

    private String review;
}