package com.teamagile.housingservice.repository.interfaces;

import com.teamagile.housingservice.entity.FacilityReport;

import java.util.List;

public interface FacilityReportRepository {
    FacilityReport addFacilityReport(FacilityReport facilityReport);

    FacilityReport getFacilityReportById(Integer id);

    List<FacilityReport> getAllFacilityReports();

    FacilityReport updateFacilityReportInfo(Integer id);

    void deleteFacilityReport(Integer id);
}
