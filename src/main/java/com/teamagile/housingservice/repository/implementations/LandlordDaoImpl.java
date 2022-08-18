package com.teamagile.housingservice.repository.implementations;

import com.teamagile.housingservice.entity.Landlord;
import com.teamagile.housingservice.repository.AbstractHibernateDAO;
import com.teamagile.housingservice.repository.interfaces.LandlordRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LandlordDaoImpl extends AbstractHibernateDAO<Landlord> implements LandlordRepository {
    public LandlordDaoImpl() {
        setClazz(Landlord.class);
    }
    @Override
    public Landlord getLandlordById(Integer id) {
        return findById(id);
    }
}
