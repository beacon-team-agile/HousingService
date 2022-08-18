package com.teamagile.housingservice.repository.implementations;

import com.teamagile.housingservice.entity.Facility;
import com.teamagile.housingservice.repository.AbstractHibernateDAO;
import com.teamagile.housingservice.repository.interfaces.FacilityRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FacilityDaoImpl extends AbstractHibernateDAO<Facility> implements FacilityRepository {

    public FacilityDaoImpl() {
        setClazz(Facility.class);
    }
    @Override
    public Facility getFacilityById(Integer id) {
        return findById(id);
    }
}
