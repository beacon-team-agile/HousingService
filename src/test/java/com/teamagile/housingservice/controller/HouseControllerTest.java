package com.teamagile.housingservice.controller;

import com.google.gson.Gson;
import com.teamagile.housingservice.domain.common.ResponseStatus;
import com.teamagile.housingservice.entity.*;
import com.teamagile.housingservice.exception.HouseNotFoundException;
import com.teamagile.housingservice.service.HouseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HouseController.class)
@ExtendWith(MockitoExtension.class)
public class HouseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    HouseService houseService;

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

//    @Test
//    public void testGetHouse_success() throws Exception {
//
//        when(houseService.getHouseById(1)).thenReturn(mockHouse);
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/housing/{houseId}", "1")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//        House house = new Gson().fromJson(result.getResponse().getContentAsString(), House.class);
//        assertEquals(mockHouse.toString(), house.toString());
//    }
//
//    @Test
//    public void testGetEmployee_whenEmployeeNotFound() throws Exception {
//        when(houseService.getHouseById(-1)).thenThrow(new HouseNotFoundException("House Not Found"));
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/housing/{houseId}", "-1")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//        ResponseStatus responseStatus = new Gson().fromJson(result.getResponse().getContentAsString(), ResponseStatus.class);
//        assertFalse(responseStatus.getSuccess());
//        assertNotNull(responseStatus.getMessage());
//    }
}
