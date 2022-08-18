package com.teamagile.housingservice.repository.implementations;

import com.teamagile.housingservice.entity.House;
import com.teamagile.housingservice.repository.AbstractHibernateDAO;
import com.teamagile.housingservice.repository.interfaces.HouseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HouseDaoImpl extends AbstractHibernateDAO<House> implements HouseRepository {
    public HouseDaoImpl() {
        setClazz(House.class);
    }
    @Override
    public Integer createHouse(House house) {
        return add(house);
    }

    @Override
    public House getHouseById(Integer id) {
        return findById(id);
    }

    @Override
    public List<House> getAllHouses() {
        return findAll();
    }

    @Override
    public void deleteHouse(Integer id) {
        delete(id);
    }
}
