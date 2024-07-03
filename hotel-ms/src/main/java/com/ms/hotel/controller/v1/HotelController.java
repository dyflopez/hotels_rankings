package com.ms.hotel.controller.v1;

import com.ms.hotel.controller.v1.doc.HotelDoc;
import com.ms.hotel.dto.HotelDto;
import com.ms.hotel.model.HotelEntity;
import com.ms.hotel.service.IHotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class HotelController implements HotelDoc {

    private final IHotelService iHotelService;

    @Override
    public ResponseEntity<HotelEntity> create(HotelDto hotelDTO) {
        return this.iHotelService.create(hotelDTO);
    }

    @Override
    public ResponseEntity<List<HotelEntity>> getAll() {
        return this.iHotelService.getAll();
    }

    @Override
    public ResponseEntity<HotelEntity> getById(UUID id) {
        return this.iHotelService.getById(id);
    }
}
