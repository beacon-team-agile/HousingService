package com.teamagile.housingservice.repository;

import com.teamagile.housingservice.entity.House;
import com.teamagile.housingservice.repository.implementations.HouseRepoImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles(value = "test")
@SpringBootTest
public class HouseRepositoryTest {
    @Autowired
    HouseRepoImp houseRepoImp;

    House mockHouse;

    @BeforeEach
    public void setup() {
        House.HouseBuilder houseBuilder = House.builder().Id(100).landlordId(100).address("123 Here St").maxOccupant(4);
        mockHouse = houseBuilder.build();
    }

//    CREATE
    @Test
    @Transactional
    public void testCreateHouse_successful() {
        House newHouse = houseRepoImp.addHouse(mockHouse);
        assertEquals(mockHouse, newHouse);
    }

    @Test
    @Transactional
    public void testCreateHouse_unsuccessful() {
        House newHouse = houseRepoImp.addHouse(null);
        assertNull(newHouse);
    }

//    GET BY ID
    @Test
    @Transactional
    public void testGetHouseById_found() {
        House newHouse = houseRepoImp.addHouse(mockHouse);
        assertEquals(mockHouse, houseRepoImp.getHouseById(newHouse.getId()));
    }

    @Test
    @Transactional
    public void testGetHouseById_notfound() {assertNull(houseRepoImp.getHouseById(-1));}

//    GET ALL
    @Test
    @Transactional
    public void testGetAllHouses_found() {
        List<House> houseList = new ArrayList<>();
        House newh1 = houseRepoImp.addHouse(mockHouse);
        House newh2 = houseRepoImp.addHouse(mockHouse);
        houseList.add(newh1);
        houseList.add(newh2);
        houseRepoImp.findAll();
        assertEquals(2, houseList.size());
    }

// TODO: Implement Tests for update and delete methods
//    UPDATE BY ID
    @Test
    @Transactional
    public void testUpdateHouseById_successful() {}

    @Test
    @Transactional
    public void testUpdateHouseById_unsuccessful() {}

//    DELETE BY ID
    @Test
    @Transactional
    public void testDeleteHouseById_successful() {}

    @Test
    @Transactional
    public void testDeleteHouseById_unsuccessful() {}
}
