package com.teamagile.housingservice.repository.implementations;

import com.teamagile.housingservice.entity.FacilityReportDetail;
import com.teamagile.housingservice.repository.AbstractHibernateDAO;
import com.teamagile.housingservice.repository.interfaces.FacilityReportDetailRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacilityReportDetailDaoImpl extends AbstractHibernateDAO<FacilityReportDetail> implements FacilityReportDetailRepository {
    public FacilityReportDetailDaoImpl() {
        setClazz(FacilityReportDetail.class);
    }


    @Override
    public Integer addFacilityReportDetail(FacilityReportDetail facilityReportDetail) {
        return add(facilityReportDetail);
    }

    @Override
    public FacilityReportDetail getFacilityReportDetailById(Integer id) {
        return findById(id);
    }

    @Override
    public List<FacilityReportDetail> getAllFacilityReportDetails() {
        return findAll();
    }

    @Override
    public FacilityReportDetail updateFacilityReportDetailInfo(Integer id, FacilityReportDetail facilityReportDetail) {
        return null;
    }
}
