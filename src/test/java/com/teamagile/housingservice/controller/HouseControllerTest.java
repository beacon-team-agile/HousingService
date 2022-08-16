package com.teamagile.housingservice.controller;

import com.google.gson.Gson;
import com.teamagile.housingservice.domain.response.AllHousesResponse;
import com.teamagile.housingservice.domain.response.HouseResponse;
import com.teamagile.housingservice.entity.*;
import com.teamagile.housingservice.service.HouseService;
import com.teamagile.housingservice.service.LandlordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HouseController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public class HouseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    HouseService houseService;

    @MockBean
    LandlordService landlordService;
    House mockHouse;
    Landlord mockLandlord;
    Facility mockFacility;
    FacilityReport mockFR;
    FacilityReportDetail mockFRD;

    @BeforeEach
    public void setup() {
        List<House> houseList = new ArrayList();
        houseList.add(mockHouse);

        List<Facility> facilityList = new ArrayList();
        facilityList.add(mockFacility);

        mockLandlord = Landlord.builder().firstName("test").lastName("test").email("test@email.com")
                .cellPhone("123456789").houseList(houseList).build();
        mockHouse = House.builder().landlordId(mockLandlord).address("123 Here St").maxOccupant(4).facilityList(facilityList).build();
        mockFacility = Facility.builder().houseId(mockHouse).type("Bed").description("King size bed").quantity(4).build();
        mockFR = FacilityReport.builder().facilityId(mockFacility).employeeId("test").title("test")
                .description("test").createDate(Date.valueOf("2000-01-01")).status("open").build();
        mockFRD = FacilityReportDetail.builder().facilityReportId(mockFR).employeeId("test")
                .comment("test").createDate(Date.valueOf("2000-01-01")).lastModificationDate(Date.valueOf("2000-01-01")).build();


    }

    @Test
    public void testCreateHouse_success() throws Exception{
        when(houseService.createHouse(mockHouse)).thenReturn(1);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/housing/{landlordId}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(request()))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        HouseResponse houseResponse = new Gson().fromJson(result.getResponse().getContentAsString(), HouseResponse.class);

        assertTrue(houseResponse.getResponseStatus().getSuccess());
    }

    @Test
    public void testGetHouse_success() throws Exception {
        when(houseService.getHouseById(1)).thenReturn(mockHouse);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/housing/{houseId}", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        HouseResponse house = new Gson().fromJson(result.getResponse().getContentAsString(), HouseResponse.class);
        assertEquals(house.getResponseStatus().getSuccess(), true);
    }

    @Test
    public void testGetHouse_whenHouseNotFound() throws Exception {
        when(houseService.getHouseById(-1)).thenReturn(null);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/housing/{houseId}", "-1")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();
        HouseResponse house = new Gson().fromJson(result.getResponse().getContentAsString(), HouseResponse.class);
        assertEquals(house.getResponseStatus().getSuccess(), false);
    }

    @Test
    public void testGetAllHouses_successful() throws Exception {
        List<House> houseList = new ArrayList();
        houseList.add(mockHouse);
        when(houseService.getAllHouses()).thenReturn(houseList);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/housing/all")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();

        AllHousesResponse response = new Gson().fromJson(result.getResponse().getContentAsString(), AllHousesResponse.class);
        assertEquals(response.getResponseStatus().getSuccess(), true);
    }

}
