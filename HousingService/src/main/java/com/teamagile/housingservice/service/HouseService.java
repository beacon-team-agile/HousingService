package com.teamagile.housingservice.service;

import com.teamagile.housingservice.repository.implementations.HouseRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService {
    private HouseRepoImp houseRepoImp;

    @Autowired
    public void setHouseRepoImp(HouseRepoImp houseRepoImp) {
        this.houseRepoImp = houseRepoImp;
    }

}
