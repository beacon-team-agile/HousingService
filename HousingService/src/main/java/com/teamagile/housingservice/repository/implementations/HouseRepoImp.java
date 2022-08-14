package com.teamagile.housingservice.repository.implementations;

import com.teamagile.housingservice.entity.House;
import com.teamagile.housingservice.repository.AbstractHibernateDAO;
import com.teamagile.housingservice.repository.interfaces.HouseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HouseRepoImp extends AbstractHibernateDAO<House> implements HouseRepository {

    @Override
    public House addHouse(House house) {
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
    public House updateHouseInfo(Integer id) {
        return null;
    }

    @Override
    public void deleteHouse(Integer id) {

    }
}
