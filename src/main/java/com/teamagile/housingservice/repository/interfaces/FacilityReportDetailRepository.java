package com.teamagile.housingservice.repository.interfaces;

import com.teamagile.housingservice.entity.FacilityReportDetail;

import java.util.List;
import java.util.Optional;

public interface FacilityReportDetailRepository {
    Integer addFacilityReportDetail(FacilityReportDetail facilityReportDetail);

    FacilityReportDetail getFacilityReportDetailById(Integer id);

    List<FacilityReportDetail> getAllFacilityReportDetails();

    void updateFacilityReportDetailInfo(Integer id, String comment);

    List<FacilityReportDetail> getFacilityReportDetailsByFacilityReportId(Integer facilityReportId);
}
