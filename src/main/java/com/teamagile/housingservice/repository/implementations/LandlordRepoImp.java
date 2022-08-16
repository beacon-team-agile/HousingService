package com.teamagile.housingservice.repository.implementations;

import com.teamagile.housingservice.entity.House;
import com.teamagile.housingservice.entity.Landlord;
import com.teamagile.housingservice.repository.AbstractHibernateDAO;
import org.springframework.stereotype.Repository;

@Repository
public class LandlordRepoImp extends AbstractHibernateDAO<Landlord> {
    public LandlordRepoImp() {
        setClazz(Landlord.class);
    }

    public Landlord getLandlordById(Integer id) {
        return findById(id);
    }
}
