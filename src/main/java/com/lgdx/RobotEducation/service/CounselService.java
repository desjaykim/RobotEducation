package com.lgdx.RobotEducation.service;

import com.lgdx.RobotEducation.domain.Counsel;
import com.lgdx.RobotEducation.domain.CounselInfo;
import com.lgdx.RobotEducation.dto.CounselDTO;
import com.lgdx.RobotEducation.dto.CounselInfoDTO;
import com.lgdx.RobotEducation.repository.CounselInfoRepository;
import com.lgdx.RobotEducation.repository.CounselRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CounselService {

    private final CounselRepository counselRepository;
    private final CounselInfoRepository counselInfoRepository;

    public CounselDTO saveCounsel(CounselDTO counselDTO, CounselInfoDTO counselInfoDTO) {
        Counsel counsel = counselDTO.toEntity();
        Counsel savedCounsel = counselRepository.save(counsel);

        CounselInfo counselInfo = counselInfoDTO.toEntity();
        counselInfo.setCounselId(savedCounsel.getCounselId());  // Counsel ID 설정
        counselInfoRepository.save(counselInfo);

        return CounselDTO.from(savedCounsel);
    }
}
