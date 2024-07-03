package com.ms.hotel.repository;

import com.ms.hotel.model.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IHotelRepository extends JpaRepository<HotelEntity, UUID> {
}