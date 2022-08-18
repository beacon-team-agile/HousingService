package com.teamagile.housingservice.repository.interfaces;

import com.teamagile.housingservice.entity.Facility;

public interface FacilityRepository {
    Facility getFacilityById(Integer id);
}
