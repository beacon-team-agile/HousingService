package com.teamagile.housingservice.domain.response;

import com.teamagile.housingservice.domain.HouseAbstract;
import com.teamagile.housingservice.domain.common.ResponseStatus;
import com.teamagile.housingservice.entity.House;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SingleHouseResponse {
    private ResponseStatus responseStatus;
    private HouseAbstract house;
}