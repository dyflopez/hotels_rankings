package com.ms.hotel.repository;

import com.ms.hotel.model.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IHotelRepository extends JpaRepository<HotelEntity, UUID> {
}