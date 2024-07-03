package com.ms.hotel.service.impl;

import com.ms.hotel.dto.HotelDto;
import com.ms.hotel.model.HotelEntity;
import com.ms.hotel.repository.IHotelRepository;
import com.ms.hotel.service.IHotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements IHotelService {

    private final IHotelRepository iHotelRepository;

    @Override
    public ResponseEntity<List<HotelEntity>> getAll() {
        List<HotelEntity> hotels = this.iHotelRepository.findAll();
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(hotels);
    }

    @Override
    public ResponseEntity<HotelEntity> create(HotelDto hotelDTO) {

        HotelEntity hotel = HotelEntity
                .builder()
                .name(hotelDTO.getName())
                .information(hotelDTO.getInformation())
                .location(hotelDTO.getLocation())
                .build();

        HotelEntity newHotel = this.iHotelRepository.save(hotel);



        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newHotel);
    }

    @Override
    public ResponseEntity<HotelEntity> getById(UUID id) {

        Optional<HotelEntity> hotelOp = this.iHotelRepository.findById(id);

        if(hotelOp.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(hotelOp.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HotelEntity());
    }

    @Override
    public void deleteById(UUID id) {
        this.iHotelRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<HotelEntity> updateById(HotelDto hotelDto, UUID id) {
        return null;
    }
}
