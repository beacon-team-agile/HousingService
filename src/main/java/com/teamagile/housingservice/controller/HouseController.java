package com.teamagile.housingservice.controller;

import com.teamagile.housingservice.domain.request.HouseCreateRequest;
import com.teamagile.housingservice.domain.response.AllHousesResponse;
import com.teamagile.housingservice.domain.response.HouseResponse;
import com.teamagile.housingservice.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("housing-service")
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
    public HouseResponse createHouse(@RequestBody HouseCreateRequest request) {
        return null;
    }

    @GetMapping("/{houseId}")
    public HouseResponse getHouseById(@PathVariable Integer houseId) {
        return null;
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
