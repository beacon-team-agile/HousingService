package com.teamagile.housingservice.controller;

import com.teamagile.housingservice.domain.common.ResponseStatus;
import com.teamagile.housingservice.domain.response.AllHousesResponse;
import com.teamagile.housingservice.domain.response.HouseResponse;
import com.teamagile.housingservice.entity.House;
import com.teamagile.housingservice.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("housing")
public class HouseController {
    private HouseService houseService;
    private RestTemplate restTemplate;

    @Autowired
    public void HouseService(HouseService houseService){
        this.houseService = houseService;
    }

    @Autowired
    public void setRestTemplate(HouseService houseService, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.houseService = houseService;
    }

    @PostMapping
    public HouseResponse createHouse(@RequestBody House request) {
        House house = House.builder()
                .landlordId(request.getLandlordId())
                .address(request.getAddress())
                .maxOccupant(request.getMaxOccupant())
                .build();

        houseService.createHouse(house);

        return HouseResponse.builder()
                .responseStatus(ResponseStatus.builder().success(true).message("House Created!").build())
                .house(house)
                .build();
    }

    @GetMapping("/{houseId}")
    public HouseResponse getHouseById(@PathVariable Integer houseId) {
        Optional<House> houseOptional = Optional.ofNullable(houseService.getHouseById(houseId));
        if (!houseOptional.isPresent()) {
            return HouseResponse.builder()
                    .responseStatus(ResponseStatus.builder()
                            .success(false)
                            .message("House Not Found!")
                            .build())
                    .house(null)
                    .build();
        }
        return HouseResponse.builder()
                .responseStatus(ResponseStatus.builder()
                        .success(false)
                        .message("House Found Successfully!")
                        .build())
                .house(houseOptional.get())
                .build();
    }

    @GetMapping("all")
    public AllHousesResponse getAllHouses() {
        return null;
    }

    @PatchMapping("/{houseId}")
    public void updateHouseInfo(@PathVariable Integer houseId) {}

    @DeleteMapping("/{houseId}")
    public void deleteHouse(@PathVariable Integer houseId) {}
}
