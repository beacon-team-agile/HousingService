package com.teamagile.housingservice.domain.response;

import com.teamagile.housingservice.entity.Facility;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import com.teamagile.housingservice.domain.common.ResponseStatus;
import com.teamagile.housingservice.entity.House;

import java.util.List;

@Getter
@Setter
@Builder
public class HouseResponse {
    private ResponseStatus responseStatus;
    private House house;
    private List<Facility> facilityList;
}
