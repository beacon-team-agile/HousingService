package com.teamagile.housingservice.repository.implementations;

import com.teamagile.housingservice.entity.FacilityReport;
import com.teamagile.housingservice.repository.interfaces.FacilityReportRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacilityReportRepoImp implements FacilityReportRepository {

    @Override
    public FacilityReport addFacilityReport(FacilityReport facilityReport) {
        return null;
    }

    @Override
    public FacilityReport getFacilityReportById(Integer id) {
        return null;
    }

    @Override
    public List<FacilityReport> getAllFacilityReports() {
        return null;
    }

    @Override
    public FacilityReport updateFacilityReportInfo(Integer id) {
        return null;
    }

    @Override
    public void deleteFacilityReport(Integer id) {

    }
}
