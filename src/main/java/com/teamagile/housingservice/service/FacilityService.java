package com.teamagile.housingservice.service;

import com.teamagile.housingservice.entity.Facility;
import com.teamagile.housingservice.exception.FacilityNotFoundException;
import com.teamagile.housingservice.repository.implementations.FacilityDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FacilityService {
    private FacilityDaoImpl facilityDaoImpl;

    @Autowired
    public void setFacilityService(FacilityDaoImpl facilityDaoImpl) {
        this.facilityDaoImpl = facilityDaoImpl;
    }

    @Transactional
    public Facility getFacilityById(int id) throws FacilityNotFoundException {
        return Optional.ofNullable(facilityDaoImpl.getFacilityById(id))
                .orElseThrow(() -> new FacilityNotFoundException("Facility Not Found!"));
    }
}
