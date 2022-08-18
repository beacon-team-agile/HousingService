package com.teamagile.housingservice.repository.interfaces;

import com.teamagile.housingservice.entity.Facility;

import java.util.List;

public interface FacilityRepository {
    Facility getFacilityById(Integer id);

    List<Facility> getFacilityByHouseId (Integer houseId);
}
