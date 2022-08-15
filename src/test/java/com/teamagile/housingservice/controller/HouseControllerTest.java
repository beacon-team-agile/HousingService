package com.teamagile.housingservice.controller;

import com.teamagile.housingservice.entity.*;
import com.teamagile.housingservice.repository.implementations.HouseRepoImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;

@WebMvcTest(HouseController.class)
@ExtendWith(MockitoExtension.class)
public class HouseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
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

    @Test
    public void testCreateHouse_successful() {}

    @Test
    public void testCreateHouse_unsuccessful() {}

}
