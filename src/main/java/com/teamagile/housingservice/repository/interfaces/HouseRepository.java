package com.teamagile.housingservice.repository.interfaces;

import com.teamagile.housingservice.entity.House;

import java.util.List;

public interface HouseRepository {
    Integer createHouse(House house);

    House getHouseById(Integer id);

    List<House> getAllHouses();

    House updateHouseInfoById(Integer id);

    void deleteHouse(Integer id);
}
