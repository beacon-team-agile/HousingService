package com.teamagile.housingservice.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractHibernateDAO<T extends Serializable> {
    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    public T findById(final Integer id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    public Integer add(final T t) {
        return (Integer) getCurrentSession().save(t);
    }

    public List<T> findAll() {return getCurrentSession().createQuery("from " + clazz.getName()).list();}

    public void delete(final Integer id) {
        final T t = findById(id);
        getCurrentSession().delete(t);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
