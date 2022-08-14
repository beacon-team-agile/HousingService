package com.teamagile.housingservice.repository.interfaces;

import com.teamagile.housingservice.entity.House;

import java.util.List;

public interface HouseRepository {
    House addHouse(House house);

    House getHouseById(Integer id);

    List<House> getAllHouses();

    House updateHouseInfo(Integer id);

    void deleteHouse(Integer id);
}
