package com.ms.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RankingDto {

    private String id;

    private String userId;

    private  String hotelId;

    private int score;

    private String review;

    private HotelDto hotel;
}
