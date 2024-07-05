package com.ms.ranking.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("ranking")
public class RankingDocument {
    @Id
    private String id;

    private String userId;

    private String hotelId;

    private int score;

    private String review;
}
