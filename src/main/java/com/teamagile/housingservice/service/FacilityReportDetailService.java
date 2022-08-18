package com.teamagile.housingservice.service;

import com.teamagile.housingservice.entity.FacilityReport;
import com.teamagile.housingservice.entity.FacilityReportDetail;
import com.teamagile.housingservice.exception.FacilityReportDetailNotFoundException;
import com.teamagile.housingservice.repository.implementations.FacilityReportDetailDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityReportDetailService {
    private FacilityReportDetailDaoImpl facilityReportDetailDaoImpl;

    @Autowired
    public void setFacilityReportDetailRepoImp(FacilityReportDetailDaoImpl facilityReportDetailDaoImpl) {
        this.facilityReportDetailDaoImpl = facilityReportDetailDaoImpl;
    }

    @Transactional
    public Integer addFacilityReportDetail(FacilityReportDetail facilityReportDetail){
        return facilityReportDetailDaoImpl.addFacilityReportDetail(facilityReportDetail);
    }

    @Transactional
    public FacilityReportDetail getFacilityReportDetailById(int id) throws FacilityReportDetailNotFoundException {
        return Optional.ofNullable(facilityReportDetailDaoImpl.getFacilityReportDetailById(id))
                .orElseThrow(() -> new FacilityReportDetailNotFoundException("Facility Report Details Not Found!"));
    }

    @Transactional
    public List<FacilityReportDetail> getAllFacilityReportDetails() {
        return facilityReportDetailDaoImpl.getAllFacilityReportDetails();
    }

    @Transactional
    public void updateFacilityReportDetailInfo(Integer Id, String comment) {
        facilityReportDetailDaoImpl.updateFacilityReportDetailInfo(Id, comment);
    }

    @Transactional
    public List<FacilityReportDetail> getFacilityReportDetailsByFacilityId(Integer facilityReportId) {
        return facilityReportDetailDaoImpl.getFacilityReportDetailsByFacilityReportId(facilityReportId);
    }
}
