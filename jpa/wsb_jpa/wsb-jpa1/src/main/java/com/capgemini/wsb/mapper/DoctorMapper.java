package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

public final class DoctorMapper {

    public static DoctorTO mapToTO(final DoctorEntity doctor) {
        if (doctor == null) {
            return null;
        }
        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctor.getId());
        doctorTO.setFirstName(doctor.getFirstName());
        doctorTO.setLastName(doctor.getLastName());
        doctorTO.setTelephoneNumber(doctor.getTelephoneNumber());
        doctorTO.setEmail(doctor.getEmail());
        doctorTO.setDoctorNumber(doctor.getDoctorNumber());
        doctorTO.setSpecialization(doctor.getSpecialization());
        return doctorTO;
    }
}
