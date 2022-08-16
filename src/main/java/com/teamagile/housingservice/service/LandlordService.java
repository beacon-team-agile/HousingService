package com.teamagile.housingservice.service;

import com.teamagile.housingservice.entity.House;
import com.teamagile.housingservice.entity.Landlord;
import com.teamagile.housingservice.exception.HouseNotFoundException;
import com.teamagile.housingservice.repository.implementations.HouseRepoImp;
import com.teamagile.housingservice.repository.implementations.LandlordRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LandlordService {
    private LandlordRepoImp landlordRepoImp;

    @Autowired
    public void setLandlordService(LandlordRepoImp landlordRepoImp) {
        this.landlordRepoImp = landlordRepoImp;
    }

    @Transactional
    public Landlord getLandlordById(int id) throws HouseNotFoundException {
        return Optional.ofNullable(landlordRepoImp.getLandlordById(id))
                .orElseThrow(() -> new HouseNotFoundException("House Not Found!"));
    }

}
