package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.service.VisitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceImplTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitService visitService;

    @Transactional
    @Test
    public void testShouldDeletePatientById() {
        // given
        // when
        patientService.deleteById(1L);
        // then
        assertThat(patientService.findById(1L)).isNull();

        List<VisitTO> visits = visitService.findVisitsByPatientId(1);
        assertThat(visits).isEmpty();
    }

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        // when
        PatientTO patient = patientService.findById(1L);
        //then
        assertThat(patient).isNotNull();
        assertThat(patient.getId()).isEqualTo(1L);
        assertThat(patient.getFirstName()).isEqualTo("Jan");
        assertThat(patient.getLastName()).isEqualTo("Nowak");
        assertThat(patient.getTelephoneNumber()).isEqualTo("421753213");
        assertThat(patient.getEmail()).isEqualTo("jan@nowak.pl");
        assertThat(patient.getPatientNumber()).isEqualTo("123");
        assertThat(patient.getDateOfBirth()).isEqualTo(LocalDate.of(2015, 1, 13));
        assertThat(patient.getHeight()).isEqualTo(175.2);
    }
}