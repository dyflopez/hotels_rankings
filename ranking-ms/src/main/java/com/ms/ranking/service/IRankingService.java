package com.ms.ranking.service;

import com.ms.ranking.dto.RankingDTO;
import com.ms.ranking.model.RankingDocument;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRankingService {
    ResponseEntity<RankingDocument> create(RankingDTO rankingDTO);

    ResponseEntity<List<RankingDocument>> getAll();

    ResponseEntity<List<RankingDocument>> getByUserId(String userId);

    ResponseEntity<List<RankingDocument>> getByHotelId(String hotelId);

}
