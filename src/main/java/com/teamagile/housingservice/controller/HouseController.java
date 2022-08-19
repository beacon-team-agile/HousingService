package com.teamagile.housingservice.controller;

import com.teamagile.housingservice.domain.FacilityAbstract;
import com.teamagile.housingservice.domain.HouseAbstract;
import com.teamagile.housingservice.domain.LandlordAbstract;
import com.teamagile.housingservice.domain.common.ResponseStatus;
import com.teamagile.housingservice.domain.response.AllHousesResponse;
import com.teamagile.housingservice.domain.response.HouseResponse;
import com.teamagile.housingservice.domain.response.SingleHouseResponse;
import com.teamagile.housingservice.entity.House;
import com.teamagile.housingservice.exception.HouseNotFoundException;
import com.teamagile.housingservice.exception.LandlordNotFoundException;
import com.teamagile.housingservice.service.HouseService;
import com.teamagile.housingservice.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("housing")
public class HouseController {
    private HouseService houseService;

    private LandlordService landlordService;

    @Autowired
    public void HouseService(HouseService houseService){
        this.houseService = houseService;
    }
    @Autowired
    public void LandlordService(LandlordService landlordService){
        this.landlordService = landlordService;
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

    @GetMapping("/get_house/{houseId}")
    public SingleHouseResponse getHouseById(@PathVariable Integer houseId) throws HouseNotFoundException {
        Optional<House> houseOptional = Optional.ofNullable(houseService.getHouseById(houseId));
        if (!houseOptional.isPresent()) {
            return SingleHouseResponse.builder()
                    .responseStatus(ResponseStatus.builder()
                            .is_success(false)
                            .message("House Not Found!")
                            .build())
                    .house(null)
                    .build();
        }
        House h = houseOptional.get();
        return SingleHouseResponse.builder()
                .responseStatus(ResponseStatus.builder()
                        .is_success(true)
                        .message("House Found Successfully!")
                        .build())
                .house(
                		HouseAbstract.builder()
                		.address(h.getAddress())
                		.maxOccupant(h.getMaxOccupant())
                		.landlord(LandlordAbstract.builder()
                				.firstName(h.getLandlordId().getFirstName())
                				.lastName(h.getLandlordId().getLastName())
                				.cellPhone(h.getLandlordId().getCellPhone())
                				.email(h.getLandlordId().getEmail())
                				.build())
                		.facilityList(h.getFacilityList().stream()
                				.map(f -> 
                					FacilityAbstract.builder()
                							.id(f.getId())
                							.type(f.getType())
                							.description(f.getDescription())
                							.quantity(f.getQuantity())
                							.build()
                				).collect(Collectors.toList()))          		
                		.build()
                		)
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
