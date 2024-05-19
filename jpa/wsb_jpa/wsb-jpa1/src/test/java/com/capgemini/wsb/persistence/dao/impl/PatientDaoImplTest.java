package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoImplTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientsByLastname() {
        // given
        // when
        List<PatientEntity> result = patientDao.findByLastname("Nowak");

        // then
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getId()).isEqualTo(1);
        assertThat(result.get(0).getLastName()).isEqualTo("Nowak");
        assertThat(result.get(0).getFirstName()).isEqualTo("Jan");
        assertThat(result.get(0).getTelephoneNumber()).isEqualTo("421753213");
        assertThat(result.get(0).getEmail()).isEqualTo("jan@nowak.pl");
        assertThat(result.get(0).getPatientNumber()).isEqualTo("123");
        assertThat(result.get(0).getDateOfBirth()).isEqualTo("2015-01-13");
        assertThat(result.get(0).getHeight()).isEqualTo( 175.2);
    }

    @Transactional
    @Test
    public void testShouldFindPatientsWithVisitsGreaterThan() {
        //given
        int greaterThan = 2;

        //when
        List<PatientEntity> result = patientDao.findByVisitsGreaterThan(greaterThan);

        //then
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getId()).isEqualTo(1);
    }

    @Transactional
    @Test
    public void testShouldFindPatientsWithHeightLowerThan() {
        //given
        double lowerThan = 160.5;

        //when
        List<PatientEntity> result = patientDao.findByHeightLowerThan(lowerThan);

        //then
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getId()).isEqualTo(2);
    }
}