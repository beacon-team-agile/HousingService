package com.teamagile.housingservice.service;

import com.teamagile.housingservice.entity.*;
import com.teamagile.housingservice.repository.implementations.HouseRepoImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;

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
        mockFR = FacilityReport.builder().Id(100).facilityId(mockFacility).employeeId(100).title("test")
                .description("test").createDate(Date.valueOf("2000-01-01")).status("open").build();
        mockFRD = FacilityReportDetail.builder().Id(100).facilityReportId(mockFR).employeeId(100)
                .comment("test").createDate(Date.valueOf("2000-01-01")).lastModificationDate(Date.valueOf("2000-01-01")).build();
    }

//    CREATE
    @Test
    public void createHouse_successful() {}

    @Test
    public void createHouse_unsuccessfulWhenAddressIsEmpty() {}

    @Test
    public void createHouse_unsuccessfulWhenAddressExisted() {}

//    GET HOUSE BY ID
    @Test
    public void getHouseById_successful() {}

    @Test
    public void getHouseById_unsuccessfulWhenNegativeId() {}

    @Test
    public void getHouseById_unsuccessfulWhenStringId() {}

//    GET ALL HOUSES
    @Test
    public void getAllHouses_successful() {}

//    UPDATE HOUSE
    @Test
    public void updateHouse_successful() {}

    @Test
    public void updateHouse_unsuccessfulWhenAddressIsEmpty() {}

//    DELETE HOUSE
    @Test
    public void deleteHouse_successful() {}
}
