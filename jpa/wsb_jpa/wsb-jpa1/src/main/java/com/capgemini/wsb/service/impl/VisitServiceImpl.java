package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.VisitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {

    private final VisitDao visitDao;

    public VisitServiceImpl(VisitDao visitDao) {
        this.visitDao = visitDao;
    }

    @Override
    public List<VisitTO> findVisitsByPatientId(long patientId) {
        List<VisitEntity> visits = visitDao.findVisitsByPatientId(patientId);
        List<VisitTO> visitTOs = new ArrayList<>();
        for (VisitEntity visitEntity : visits) {
            visitTOs.add(VisitMapper.mapToTO(visitEntity));
        }
        return visitTOs;
    }
}
