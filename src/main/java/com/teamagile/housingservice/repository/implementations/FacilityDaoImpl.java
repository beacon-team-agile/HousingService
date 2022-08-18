package com.teamagile.housingservice.repository.implementations;

import com.teamagile.housingservice.entity.Facility;
import com.teamagile.housingservice.repository.AbstractHibernateDAO;
import com.teamagile.housingservice.repository.interfaces.FacilityRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class FacilityDaoImpl extends AbstractHibernateDAO<Facility> implements FacilityRepository {

    public FacilityDaoImpl() {
        setClazz(Facility.class);
    }
    @Override
    public Facility getFacilityById(Integer id) {
        return findById(id);
    }

    @Override
    public List<Facility> getFacilityByHouseId(Integer houseId) {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Facility> cr = cb.createQuery(Facility.class);
        Root<Facility> root = cr.from(Facility.class);

        cr.select(root);
        cr.where(cb.equal(root.get("houseId"), houseId));
        Query<Facility> query = session.createQuery(cr);
        List<Facility> results = query.getResultList();
        return results;
    }


}
