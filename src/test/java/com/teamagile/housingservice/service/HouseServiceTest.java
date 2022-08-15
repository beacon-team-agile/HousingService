package com.teamagile.housingservice.service;

import com.teamagile.housingservice.entity.*;
import com.teamagile.housingservice.exception.HouseNotFoundException;
import com.teamagile.housingservice.repository.implementations.HouseRepoImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HouseServiceTest {

    @InjectMocks
    HouseService houseService;

    @Mock
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
        mockFR = FacilityReport.builder().Id(100).facilityId(mockFacility).employeeId("test").title("test")
                .description("test").createDate(Date.valueOf("2000-01-01")).status("open").build();
        mockFRD = FacilityReportDetail.builder().Id(100).facilityReportId(mockFR).employeeId("test")
                .comment("test").createDate(Date.valueOf("2000-01-01")).lastModificationDate(Date.valueOf("2000-01-01")).build();
    }

//    CREATE
    @Test
    public void testCreateHouse_successful() {

    }

    @Test
    public void testCreateHouse_unsuccessfulWhenAddressIsEmpty() {}

    @Test
    public void testCreateHouse_unsuccessfulWhenAddressExisted() {}

//    GET HOUSE BY ID
    @Test
    public void testGetHouseById_successful() {
        when(houseRepoImp.getHouseById(100)).thenReturn(mockHouse);
        House house = houseService.getHouseById(100);
        assertEquals(mockHouse, house);
    }

    @Test
    public void testGetHouseById_unsuccessfulWhenNegativeId() {
        when(houseRepoImp.getHouseById(-100)).thenReturn(null);
        assertThrows(HouseNotFoundException.class, () -> houseService.getHouseById(-100));
    }

//    GET ALL HOUSES
    @Test
    public void testGetAllHouses_successful() {}

//    UPDATE HOUSE
    @Test
    public void testUpdateHouse_successful() {}

    @Test
    public void testUpdateHouse_unsuccessfulWhenAddressIsEmpty() {}

//    DELETE HOUSE
    @Test
    public void testDeleteHouse_successful() {}
}
