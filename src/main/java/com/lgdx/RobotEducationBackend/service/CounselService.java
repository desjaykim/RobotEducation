package com.lgdx.RobotEducationBackend.service;

import com.lgdx.RobotEducationBackend.domain.Counsel;
import com.lgdx.RobotEducationBackend.domain.CounselInfo;
import com.lgdx.RobotEducationBackend.dto.CounselDTO;
import com.lgdx.RobotEducationBackend.dto.CounselInfoDTO;
import com.lgdx.RobotEducationBackend.repository.CounselInfoRepository;
import com.lgdx.RobotEducationBackend.repository.CounselRepository;
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
