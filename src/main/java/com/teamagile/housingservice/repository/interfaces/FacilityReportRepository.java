package com.teamagile.housingservice.repository.interfaces;

import com.teamagile.housingservice.entity.FacilityReport;

import java.util.List;

public interface FacilityReportRepository {
    Integer addFacilityReport(FacilityReport facilityReport);

    FacilityReport getFacilityReportById(Integer id);

    List<FacilityReport> getAllFacilityReports();

}
