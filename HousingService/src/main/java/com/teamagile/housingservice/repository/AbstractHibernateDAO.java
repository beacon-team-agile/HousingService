package com.teamagile.housingservice.repository;

import com.google.common.base.Preconditions;
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
        return getCurrentSession().get(clazz, id);
    }

    public T add(final T t) {
        getCurrentSession().persist(t);
        return t;
    }

    public List<T> findAll() {return getCurrentSession().createQuery("from " + clazz.getName()).list();}


    public void delete(T t) {getCurrentSession().delete(t);}

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
