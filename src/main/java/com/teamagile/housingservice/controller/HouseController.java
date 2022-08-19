package com.teamagile.housingservice.controller;

import com.teamagile.housingservice.domain.common.ResponseStatus;
import com.teamagile.housingservice.domain.response.AllHousesResponse;
import com.teamagile.housingservice.domain.response.HouseResponse;
import com.teamagile.housingservice.entity.Facility;
import com.teamagile.housingservice.entity.House;
import com.teamagile.housingservice.exception.HouseNotFoundException;
import com.teamagile.housingservice.exception.LandlordNotFoundException;
import com.teamagile.housingservice.service.FacilityService;
import com.teamagile.housingservice.service.HouseService;
import com.teamagile.housingservice.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("housing")
public class HouseController {
    private HouseService houseService;

    private LandlordService landlordService;

    private FacilityService facilityService;

    @Autowired
    public void HouseService(HouseService houseService){
        this.houseService = houseService;
    }
    @Autowired
    public void LandlordService(LandlordService landlordService){
        this.landlordService = landlordService;
    }
    @Autowired
    public void FacilityService(FacilityService facilityService){
        this.facilityService = facilityService;
    }

    @PostMapping("/{landlordId}")
    public HouseResponse createHouse(@RequestBody House request, @PathVariable Integer landlordId) throws LandlordNotFoundException {

        House house = House.builder()
                .landlordId(landlordService.getLandlordById(landlordId))
                .address(request.getAddress())
                .maxOccupant(request.getMaxOccupant())
                .build();

        houseService.createHouse(house);

        return HouseResponse.builder()
                .responseStatus(ResponseStatus.builder().is_success(true).message("House Created!").build())
                .house(house)
                .build();
    }

    @GetMapping("/{houseId}")
    public HouseResponse getHouseById(@PathVariable Integer houseId) throws HouseNotFoundException {
        Optional<House> houseOptional = Optional.ofNullable(houseService.getHouseById(houseId));
        List<Facility> facility = facilityService.getFacilityByHouseId(houseId);
        if (!houseOptional.isPresent()) {
            return HouseResponse.builder()
                    .responseStatus(ResponseStatus.builder()
                            .is_success(false)
                            .message("House Not Found!")
                            .build())
                    .house(null)
                    .build();
        }
        return HouseResponse.builder()
                .responseStatus(ResponseStatus.builder()
                        .is_success(true)
                        .message("House Found Successfully!")
                        .build())
                .house(houseOptional.get())
                .facilityList(facility)
                .build();
    }

    @GetMapping("all")
    public AllHousesResponse getAllHouses() {
        List<House> houseList = houseService.getAllHouses();
        return AllHousesResponse.builder()
                .responseStatus(
                        ResponseStatus.builder()
                                .is_success(true)
                                .message("Getting All Houses!")
                                .build()
                )
                .houseList(houseList)
                .build();
    }

    @DeleteMapping("/{houseId}")
    public HouseResponse deleteHouse(@PathVariable Integer houseId) throws HouseNotFoundException {
        House house = houseService.getHouseById(houseId);
        if (house.getId().equals(houseId)) {
            houseService.deleteHouse(houseId);
            return HouseResponse.builder()
                    .responseStatus(
                            ResponseStatus.builder()
                                    .is_success(true)
                                    .message("House Deleted!")
                                    .build()
                    )
                    .house(house)
                    .build();
        } else {
            throw new HouseNotFoundException("House Not Found!");
        }
    }
}
