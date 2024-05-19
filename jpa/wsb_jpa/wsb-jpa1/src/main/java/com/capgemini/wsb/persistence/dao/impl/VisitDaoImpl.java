package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao {


    @Override
    public List<VisitEntity> findVisitsByPatientId(long patientId) {
        return entityManager.createQuery("SELECT visit FROM VisitEntity visit WHERE visit.patient.id = ?1", VisitEntity.class)
                .setParameter(1, patientId)
                .getResultList();
    }
}
