package com.teamagile.housingservice.service;

import com.teamagile.housingservice.entity.House;
import com.teamagile.housingservice.exception.HouseNotFoundException;
import com.teamagile.housingservice.repository.implementations.HouseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {
    private HouseDaoImpl houseDaoImpl;

    @Autowired
    public void setHouseRepoImp(HouseDaoImpl houseDaoImpl) {
        this.houseDaoImpl = houseDaoImpl;
    }

    @Transactional
    public Integer createHouse(House house){
        return houseDaoImpl.createHouse(house);
    }

    @Transactional
    public House getHouseById(int id) throws HouseNotFoundException {
        return Optional.ofNullable(houseDaoImpl.getHouseById(id))
                .orElseThrow(() -> new HouseNotFoundException("House Not Found!"));
    }

    @Transactional
    public List<House> getAllHouses() {
        return houseDaoImpl.getAllHouses();
    }

    @Transactional
    public void deleteHouse(Integer id) {
        houseDaoImpl.deleteHouse(id);
    }
}
