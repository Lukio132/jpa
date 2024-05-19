package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.service.VisitService;
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
public class VisitServiceImplTest {

    @Autowired
    private VisitService visitService;

    @Transactional
    @Test
    public void testShouldFindPatientVisits() {
        // given
        // when
        List<VisitTO> visits = visitService.findVisitsByPatientId(1);
        // then
        assertThat(visits).isNotEmpty();
        assertThat(visits).hasSize(3);
        assertThat(visits.get(0).getPatientData().getId()).isEqualTo(1);
        assertThat(visits.get(1).getPatientData().getId()).isEqualTo(1);
    }
}