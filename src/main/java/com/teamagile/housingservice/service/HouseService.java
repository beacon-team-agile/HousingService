package com.teamagile.housingservice.service;

import com.teamagile.housingservice.entity.House;
import com.teamagile.housingservice.repository.implementations.HouseRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {
    private HouseRepoImp houseRepoImp;

    @Autowired
    public void setHouseRepoImp(HouseRepoImp houseRepoImp) {
        this.houseRepoImp = houseRepoImp;
    }

    @Transactional
    public Integer createHouse(House house){
        return houseRepoImp.createHouse(house);
    }

    @Transactional
    public House getHouseById(int id) {
        return null;
    }

    @Transactional
    public List<House> getAllHouses() {
        return null;
    }

    @Transactional
    public void deleteHouse(Integer id) {

    }
}
