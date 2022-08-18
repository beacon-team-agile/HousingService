package com.teamagile.housingservice.repository.implementations;

import com.teamagile.housingservice.entity.FacilityReport;
import com.teamagile.housingservice.entity.FacilityReportDetail;
import com.teamagile.housingservice.repository.AbstractHibernateDAO;
import com.teamagile.housingservice.repository.interfaces.FacilityReportRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacilityReportDaoImpl extends AbstractHibernateDAO<FacilityReport> implements FacilityReportRepository {

    public FacilityReportDaoImpl() {
        setClazz(FacilityReport.class);
    }
    @Override
    public Integer addFacilityReport(FacilityReport facilityReport) {
        return add(facilityReport);
    }

    @Override
    public FacilityReport getFacilityReportById(Integer id) {
        return findById(id);
    }

    @Override
    public List<FacilityReport> getAllFacilityReports() {
        return findAll();
    }

}
