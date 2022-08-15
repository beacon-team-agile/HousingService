package com.teamagile.housingservice.domain.request;

import com.teamagile.housingservice.entity.House;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class HouseCreateRequest {
    private House house;

}
