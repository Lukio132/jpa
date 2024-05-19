package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {

    List<PatientEntity> findByLastname(String lastname);

    List<PatientEntity> findByVisitsGreaterThan(int visitsGreaterThan);

    List<PatientEntity> findByHeightLowerThan(double heightLowerThan);
}
