package com.teamagile.housingservice.repository.implementations;

import com.teamagile.housingservice.entity.FacilityReportDetail;
import com.teamagile.housingservice.repository.AbstractHibernateDAO;
import com.teamagile.housingservice.repository.interfaces.FacilityReportDetailRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.Calendar;
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
    public void updateFacilityReportDetailInfo(Integer Id, String comment) {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<FacilityReportDetail> cr = cb.createCriteriaUpdate(FacilityReportDetail.class);
        Root<FacilityReportDetail> root = cr.from(FacilityReportDetail.class);

        cr.set("comment", comment);
        cr.set("lastModificationDate", Calendar.getInstance().getTime());
        cr.where(cb.equal(root.get("Id"), Id));

        session.createQuery(cr).executeUpdate();
    }

    @Override
    public List<FacilityReportDetail> getFacilityReportDetailsByFacilityReportId(Integer facilityReportId) {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<FacilityReportDetail> cr = cb.createQuery(FacilityReportDetail.class);
        Root<FacilityReportDetail> root = cr.from(FacilityReportDetail.class);

        cr.select(root);
        cr.where(cb.equal(root.get("facilityReportId"), facilityReportId));
        Query<FacilityReportDetail> query = session.createQuery(cr);
        List<FacilityReportDetail> results = query.getResultList();
        return results;
    }
}
