package com.ms.ranking.repository;

import com.ms.ranking.model.RankingDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RankingRepository extends MongoRepository<RankingDocument,String> {

    //rankingDb.RankingDocument.find({"userId":"?"})
    List<RankingDocument> findByUserId(String usrId);


    //rankingDb.RankingDocument.find({"hotelId":"?"})
    List<RankingDocument> findByHotelId(String hotelId);

}
