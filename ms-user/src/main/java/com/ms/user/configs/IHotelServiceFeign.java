package com.ms.user.configs;

import com.ms.user.dto.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "HOTEL-MS")
public interface IHotelServiceFeign {

    @GetMapping("/api/v1/hotel/{id}")
    HotelDto getHotelById (@PathVariable("id") UUID id);

}
