package com.teamagile.housingservice.repository.interfaces;

import com.teamagile.housingservice.entity.FacilityReportDetail;

import java.util.List;

public interface FacilityReportDetailRepository {
    Integer addFacilityReportDetail(FacilityReportDetail facilityReportDetail);

    FacilityReportDetail getFacilityReportDetailById(Integer id);

    List<FacilityReportDetail> getAllFacilityReportDetails();

    FacilityReportDetail updateFacilityReportDetailInfo(Integer id, FacilityReportDetail facilityReportDetail);
}
