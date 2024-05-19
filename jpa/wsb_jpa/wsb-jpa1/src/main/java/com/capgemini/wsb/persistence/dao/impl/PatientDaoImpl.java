package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{

    @Override
    public List<PatientEntity> findByLastname(String lastname) {
        return entityManager.createQuery("SELECT patient FROM PatientEntity patient WHERE patient.lastName = ?1", PatientEntity.class)
                .setParameter(1, lastname)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findByVisitsGreaterThan(int visitsGreaterThan) {
        return entityManager.createQuery("SELECT patient FROM PatientEntity patient where patient.visits.size > ?1", PatientEntity.class)
                .setParameter(1, visitsGreaterThan)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findByHeightLowerThan(double heightLowerThan) {
        return entityManager.createQuery("SELECT patient FROM PatientEntity patient where patient.height < ?1", PatientEntity.class)
                .setParameter(1, heightLowerThan)
                .getResultList();
    }
}
