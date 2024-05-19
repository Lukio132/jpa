package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientDataTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.ArrayList;
import java.util.List;

public final class PatientMapper {

    public static PatientTO mapToTO(final PatientEntity entity) {
        if (entity == null) {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(entity.getId());
        patientTO.setFirstName(entity.getFirstName());
        patientTO.setLastName(entity.getLastName());
        patientTO.setTelephoneNumber(entity.getTelephoneNumber());
        patientTO.setEmail(entity.getEmail());
        patientTO.setPatientNumber(entity.getPatientNumber());
        patientTO.setDateOfBirth(entity.getDateOfBirth());
        patientTO.setHeight(entity.getHeight());

        List<VisitTO> visits = new ArrayList<>();
        for (VisitEntity visit : entity.getVisits()) {
            VisitTO visitTO = new VisitTO();
            visitTO.setId(visit.getId());
            visitTO.setDescription(visit.getDescription());
            visitTO.setTime(visit.getTime());

            DoctorEntity doctor = visit.getDoctor();
            DoctorTO doctorTO = DoctorMapper.mapToTO(doctor);
            visitTO.setDoctor(doctorTO);

            PatientDataTO patientDataTO = mapToPatientData(entity);
            visitTO.setPatientData(patientDataTO);

            visits.add(visitTO);
        }
        patientTO.setVisit(visits);
        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        if (patientTO == null) {
            return null;
        }
        final PatientEntity entity = new PatientEntity();
        entity.setId(patientTO.getId());
        entity.setFirstName(patientTO.getFirstName());
        entity.setLastName(patientTO.getLastName());
        entity.setTelephoneNumber(patientTO.getTelephoneNumber());
        entity.setEmail(patientTO.getEmail());
        entity.setPatientNumber(patientTO.getPatientNumber());
        entity.setDateOfBirth(patientTO.getDateOfBirth());
        entity.setHeight(patientTO.getHeight());
        return entity;
    }

    public static PatientDataTO mapToPatientData(PatientEntity entity) {
        if (entity == null) {
            return null;
        }
        PatientDataTO patientDataTO = new PatientDataTO();
        patientDataTO.setId(entity.getId());
        patientDataTO.setFirstName(entity.getFirstName());
        patientDataTO.setLastName(entity.getLastName());
        patientDataTO.setTelephoneNumber(entity.getTelephoneNumber());
        patientDataTO.setEmail(entity.getEmail());
        patientDataTO.setPatientNumber(entity.getPatientNumber());
        patientDataTO.setDateOfBirth(entity.getDateOfBirth());
        return patientDataTO;
    }
}
