package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientDataTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public final class VisitMapper {

    public static VisitTO mapToTO(final VisitEntity visit) {
        if (visit == null)
        {
            return null;
        }
        VisitTO visitTO = new VisitTO();
        visitTO.setId(visit.getId());
        visitTO.setTime(visit.getTime());
        visitTO.setDescription(visit.getDescription());
        PatientDataTO patientDataTO = PatientMapper.mapToPatientData(visit.getPatient());
        visitTO.setPatientData(patientDataTO);

        return visitTO;
    }
}
