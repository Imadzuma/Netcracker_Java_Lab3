package com.dao.impl;

import com.dao.api.Dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DaoImpl<T> implements Dao<T> {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    private Class<T> typeOfT;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void delete(Integer id) {
        Query query = getSession().createQuery("DELETE FROM " + typeOfT.getName() + " WHERE id =:id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void update(T model) {
        getSession().update(model);
    }

    @Override
    public void add(T model) {
        getSession().save(model);
    }

    @Override
    public T find(Integer id) {
        return (T)getSession().get(typeOfT.getName(), id);
    }

    @Override
    public Long count() {
        return (Long) getSession().createCriteria(typeOfT.getName()).setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public List<T> findAll() {
        String n = typeOfT.getName();
        return getSession().createQuery("FROM " + typeOfT.getName()).list();
    }
}
