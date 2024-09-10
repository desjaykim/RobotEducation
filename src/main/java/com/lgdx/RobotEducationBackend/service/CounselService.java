package com.lgdx.RobotEducationBackend.service;

import com.lgdx.RobotEducationBackend.domain.Counsel;
import com.lgdx.RobotEducationBackend.dto.CounselDTO;
import com.lgdx.RobotEducationBackend.repository.CounselRepository;
import org.springframework.stereotype.Service;

import java.util.Date;


import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CounselService {

    private final CounselRepository counselRepository;

//    @Autowired
//    public CounselService(CounselRepository counselRepository) {
//        this.counselRepository = counselRepository;
//    }
    @Transactional
    public CounselDTO saveCounsel(String counselId, Date counselDate, String customerId, String counselorId, Integer level, String reason, String education) {
        Counsel counsel = new Counsel();
        counsel.setCounselId(counselId);
        counsel.setCounselDate(new Date());
        counsel.setCustomerId(customerId);
        counsel.setCounselorId(counselorId);
        counsel.setLevel(level);
        counsel.setReason(reason);
        counsel.setEducation(education);

        counsel = counselRepository.save(counsel);
        return new CounselDTO(counsel.getCounselId(), counsel.getCounselDate(), counsel.getCustomerId(), counsel.getCounselorId(), counsel.getLevel(), counsel.getReason(), counsel.getEducation());
    }
}

