package com.teamagile.housingservice.service;

import com.teamagile.housingservice.entity.FacilityReport;
import com.teamagile.housingservice.exception.FacilityReportNotFoundException;
import com.teamagile.housingservice.repository.implementations.FacilityReportDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityReportService {
    private FacilityReportDaoImpl facilityReportDaoImpl;

    @Autowired
    public void setFacilityReportRepoImp(FacilityReportDaoImpl facilityReportDaoImpl) {
        this.facilityReportDaoImpl = facilityReportDaoImpl;
    }

    @Transactional
    public Integer addFacilityReport(FacilityReport facilityReport){
        return facilityReportDaoImpl.addFacilityReport(facilityReport);
    }

    @Transactional
    public FacilityReport getFacilityReportById(int id) throws FacilityReportNotFoundException {
        return Optional.ofNullable(facilityReportDaoImpl.getFacilityReportById(id))
                .orElseThrow(() -> new FacilityReportNotFoundException("Facility Reports Not Found!"));
    }

    @Transactional
    public List<FacilityReport> getAllFacilityReports() {
        return facilityReportDaoImpl.getAllFacilityReports();
    }
}
