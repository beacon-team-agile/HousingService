package com.teamagile.housingservice.repository;

import com.teamagile.housingservice.entity.*;
import com.teamagile.housingservice.repository.implementations.HouseRepoImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ActiveProfiles(value = "test")
@SpringBootTest
public class HouseRepositoryTest {
    @Autowired
    HouseRepoImp houseRepoImp;

    House mockHouse;
    Landlord mockLandlord;
    Facility mockFacility;
    FacilityReport mockFR;
    FacilityReportDetail mockFRD;

    @BeforeEach
    public void setup() {
        mockLandlord = Landlord.builder().Id(100).firstName("test").lastName("test").email("test@email.com")
                .cellPhone("123456789").build();
        mockHouse = House.builder().Id(100).landlordId(mockLandlord).address("123 Here St").maxOccupant(4).build();
        mockFacility = Facility.builder().Id(100).houseId(mockHouse).type("Bed").description("King size bed").quantity(4).build();
        mockFR = FacilityReport.builder().Id(100).facilityId(mockFacility).employeeId(100).title("test")
                .description("test").createDate(Date.valueOf("2000-01-01")).status("open").build();
        mockFRD = FacilityReportDetail.builder().Id(100).facilityReportId(mockFR).employeeId(100)
                .comment("test").createDate(Date.valueOf("2000-01-01")).lastModificationDate(Date.valueOf("2000-01-01")).build();
    }

//    CREATE
    @Test
    @Transactional
    public void testCreateHouse_successful() {
        House newHouse = houseRepoImp.createHouse(mockHouse);
        assertEquals(mockHouse, newHouse);
    }

    @Test
    @Transactional
    public void testCreateHouse_unsuccessful() {
        House newHouse = houseRepoImp.createHouse(null);
        assertNull(newHouse);
    }

//    GET BY ID
    @Test
    @Transactional
    public void testGetHouseById_found() {
        House newHouse = houseRepoImp.createHouse(mockHouse);
        assertEquals(mockHouse, houseRepoImp.getHouseById(newHouse.getId()));
    }

    @Test
    @Transactional
    public void testGetHouseById_notfound() {assertNull(houseRepoImp.getHouseById(null));}

//    GET ALL
    @Test
    @Transactional
    public void testGetAllHouses_found() {
        List<House> houseList = new ArrayList<>();
        House newh1 = houseRepoImp.createHouse(mockHouse);
        House newh2 = houseRepoImp.createHouse(mockHouse);
        houseList.add(newh1);
        houseList.add(newh2);
        houseRepoImp.findAll();
        assertEquals(2, houseList.size());
    }

// TODO: Implement Tests for update and delete methods
//    UPDATE BY ID
    @Test
    @Transactional
    public void testUpdateHouseById_successful() {

    }

    @Test
    @Transactional
    public void testUpdateHouseById_unsuccessful() {}

//    DELETE BY ID
    @Test
    @Transactional
    public void testDeleteHouseById_successful() {
        House newHouse = houseRepoImp.createHouse(mockHouse);
        List<House> houseList = new ArrayList<>();
        houseList.add(newHouse);
        houseRepoImp.deleteHouse(newHouse.getId());
        verify(houseList).size();
    }

}
