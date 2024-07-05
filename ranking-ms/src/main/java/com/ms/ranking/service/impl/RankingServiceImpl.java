package com.ms.ranking.service.impl;

import com.ms.ranking.dto.RankingDTO;
import com.ms.ranking.model.RankingDocument;
import com.ms.ranking.repository.RankingRepository;
import com.ms.ranking.service.IRankingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RankingServiceImpl implements IRankingService {

    private final RankingRepository rankingRepository;

    @Override
    public ResponseEntity<RankingDocument> create(RankingDTO rankingDTO) {

        RankingDocument newRanking = RankingDocument.builder()
                .hotelId(rankingDTO.getHotelId())
                .userId(rankingDTO.getUserId())
                .score(rankingDTO.getScore())
                .review(rankingDTO.getReview())
                .build();
        var ranking= this.rankingRepository.save(newRanking);
        return ResponseEntity.ok(ranking);
    }

    @Override
    public ResponseEntity<List<RankingDocument>> getAll() {
        var rankin= this.rankingRepository.findAll();
        return ResponseEntity.ok(rankin);
    }

    @Override
    public ResponseEntity<List<RankingDocument>> getByUserId(String userId) {

        var rankin= this.rankingRepository.findByUserId(userId);
        return ResponseEntity.ok(rankin);
    }

    @Override
    public ResponseEntity<List<RankingDocument>> getByHotelId(String hotelId) {
        var rankin= this.rankingRepository.findByHotelId(hotelId);
        return ResponseEntity.ok(rankin);
    }
}
