package com.teamagile.housingservice.service;

import com.teamagile.housingservice.entity.Landlord;
import com.teamagile.housingservice.exception.LandlordNotFoundException;
import com.teamagile.housingservice.repository.implementations.LandlordDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LandlordService {
    private LandlordDaoImpl landlordDaoImpl;

    @Autowired
    public void setLandlordService(LandlordDaoImpl landlordDaoImpl) {
        this.landlordDaoImpl = landlordDaoImpl;
    }

    @Transactional
    public Landlord getLandlordById(int id) throws LandlordNotFoundException {
        return Optional.ofNullable(landlordDaoImpl.getLandlordById(id))
                .orElseThrow(() -> new LandlordNotFoundException("Landlord Not Found!"));
    }

}
