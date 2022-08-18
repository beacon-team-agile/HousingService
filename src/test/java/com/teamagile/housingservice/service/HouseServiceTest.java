package com.teamagile.housingservice.service;

import com.teamagile.housingservice.entity.*;
import com.teamagile.housingservice.exception.HouseNotFoundException;
import com.teamagile.housingservice.repository.implementations.HouseDaoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HouseServiceTest {

    @InjectMocks
    HouseService houseService;

    @Mock
    HouseDaoImpl houseDaoImpl;

    House mockHouse;
    Landlord mockLandlord;
    Facility mockFacility;
    FacilityReport mockFR;
    FacilityReportDetail mockFRD;

    @BeforeEach
    public void setup() {
        mockLandlord = Landlord.builder().firstName("test").lastName("test").email("test@email.com")
                .cellPhone("123456789").build();
        mockHouse = House.builder().landlordId(mockLandlord).address("123 Here St").maxOccupant(4).build();
        mockFacility = Facility.builder().houseId(mockHouse).type("Bed").description("King size bed").quantity(4).build();
        mockFR = FacilityReport.builder().facilityId(mockFacility).employeeId("test").title("test")
                .description("test").createDate(Date.valueOf("2000-01-01")).status("open").build();
        mockFRD = FacilityReportDetail.builder().facilityReportId(mockFR).employeeId("test")
                .comment("test").createDate(Date.valueOf("2000-01-01")).lastModificationDate(Date.valueOf("2000-01-01")).build();
    }

//    CREATE
    @Test
    public void testCreateHouse_successful() {
        when(houseDaoImpl.createHouse(mockHouse)).thenReturn(1);
        assertEquals(1, houseService.createHouse(mockHouse));
    }


//    GET HOUSE BY ID
    @Test
    public void testGetHouseById_successful() throws Exception {
        when(houseDaoImpl.getHouseById(1)).thenReturn(mockHouse);
        House house = houseService.getHouseById(1);
        assertEquals(mockHouse, house);
    }

    @Test
    public void testGetHouseById_unsuccessfulWhenNegativeId() {
        when(houseDaoImpl.getHouseById(-1)).thenReturn(null);
        assertThrows(HouseNotFoundException.class, () -> houseService.getHouseById(-1));
    }

//    GET ALL HOUSES
    @Test
    public void testGetAllHouses_successful() {
        List<House> houseList = new ArrayList();
        houseList.add(mockHouse);
        when(houseDaoImpl.getAllHouses()).thenReturn(houseList);
        List<House> expected = houseService.getAllHouses();
        assertEquals(expected, houseList);
    }


//    DELETE HOUSE
    @Test
    public void testDeleteHouse_successful() {
        houseService.deleteHouse(1);
        verify(houseDaoImpl).deleteHouse(1);
    }
}
