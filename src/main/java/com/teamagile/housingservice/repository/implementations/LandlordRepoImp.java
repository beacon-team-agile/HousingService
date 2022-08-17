package com.teamagile.housingservice.repository.implementations;

import com.teamagile.housingservice.entity.Landlord;
import com.teamagile.housingservice.repository.AbstractHibernateDAO;
import com.teamagile.housingservice.repository.interfaces.LandlordRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LandlordRepoImp extends AbstractHibernateDAO<Landlord> implements LandlordRepository {
    public LandlordRepoImp() {
        setClazz(Landlord.class);
    }
    @Override
    public Landlord getLandlordById(Integer id) {
        return findById(id);
    }
}
