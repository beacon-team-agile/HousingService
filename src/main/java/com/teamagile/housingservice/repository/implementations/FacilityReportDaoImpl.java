package com.teamagile.housingservice.repository.implementations;

import com.teamagile.housingservice.entity.Facility;
import com.teamagile.housingservice.entity.FacilityReport;
import com.teamagile.housingservice.entity.FacilityReportDetail;
import com.teamagile.housingservice.repository.AbstractHibernateDAO;
import com.teamagile.housingservice.repository.interfaces.FacilityReportRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    @Override
    public List<FacilityReport> getFacilityReportsByFacilityId(Integer facilityId) {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<FacilityReport> cr = cb.createQuery(FacilityReport.class);
        Root<FacilityReport> root = cr.from(FacilityReport.class);

        cr.select(root);
        cr.where(cb.equal(root.get("facilityId"), facilityId));
        Query<FacilityReport> query = session.createQuery(cr);
        List<FacilityReport> results = query.getResultList();
        return results;
    }
}
