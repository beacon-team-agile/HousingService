package com.teamagile.housingservice.repository.implementations;

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
import java.util.Optional;

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
        mockLandlord = Landlord.builder().firstName("test").lastName("test").email("test@email.com")
                .cellPhone("123456789").build();
        mockHouse = House.builder().Id(100).landlordId(mockLandlord).address("123 Here St").maxOccupant(4).build();
        mockFacility = Facility.builder().houseId(mockHouse).type("Bed").description("King size bed").quantity(4).build();
        mockFR = FacilityReport.builder().facilityId(mockFacility).employeeId("test").title("test")
                .description("test").createDate(Date.valueOf("2000-01-01")).status("open").build();
        mockFRD = FacilityReportDetail.builder().facilityReportId(mockFR).employeeId("test")
                .comment("test").createDate(Date.valueOf("2000-01-01")).lastModificationDate(Date.valueOf("2000-01-01")).build();
    }

//    CREATE
    @Test
    @Transactional
    public void testCreateHouse_successful() {
        Integer id = houseRepoImp.createHouse(mockHouse);
        mockHouse.setId(id);
        assertEquals(1, id);
    }

    @Test
    @Transactional
    public void testCreateHouse_unsuccessful() {
        Integer id = houseRepoImp.createHouse(mockHouse);
        mockHouse.setId(id);
        assertNotEquals(-1, id);
    }

//    GET BY ID
    @Test
    @Transactional
    public void testGetHouseById_found() {
        Integer id = houseRepoImp.createHouse(mockHouse);
        assertNotNull(id);
        assertEquals(mockHouse, houseRepoImp.getHouseById(id));
    }

    @Test
    @Transactional
    public void testGetHouseById_notfound() {assertNull(houseRepoImp.getHouseById(-1));}

//    GET ALL
    @Test
    @Transactional
    public void testGetAllHouses_found() {
        List<Integer> houseList = new ArrayList<>();
        Integer id1 = houseRepoImp.createHouse(mockHouse);
        Integer id2 = houseRepoImp.createHouse(mockHouse);
        houseList.add(id1);
        houseList.add(id2);
        assertEquals(houseList.size(), houseRepoImp.findAll().size());
    }

//    DELETE BY ID
    @Test
    @Transactional
    public void testDeleteHouseById_successful() {
        Integer id = houseRepoImp.createHouse(mockHouse);
        houseRepoImp.deleteHouse(id);
        assertNull(houseRepoImp.getHouseById(id));
    }

}
