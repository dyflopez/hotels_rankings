package com.ms.hotel.service.impl;

import com.ms.hotel.dto.HotelDto;
import com.ms.hotel.model.HotelEntity;
import com.ms.hotel.repository.IHotelRepository;
import com.ms.hotel.service.IHotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements IHotelService {

    private final IHotelRepository iHotelRepository;

    @Override
    public ResponseEntity<List<HotelEntity>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<HotelEntity> create(HotelDto hotelDTO) {
        return null;
    }

    @Override
    public ResponseEntity<HotelEntity> getById(UUID id) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public ResponseEntity<HotelEntity> updateById(HotelDto hotelDto, UUID id) {
        return null;
    }
}
