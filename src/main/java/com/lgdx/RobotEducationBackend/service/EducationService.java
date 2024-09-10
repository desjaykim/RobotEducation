package com.lgdx.RobotEducationBackend.service;

import com.lgdx.RobotEducationBackend.domain.Education;
import com.lgdx.RobotEducationBackend.dto.EducationDTO;
import com.lgdx.RobotEducationBackend.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationDTO addEducation(EducationDTO educationDTO) {
        Education education = new Education();
        education.setEducationTitle(educationDTO.toEntity().getEducationTitle());
        education.setEducationDescription(educationDTO.toEntity().getEducationDescription());
        education.setCounselId(educationDTO.toEntity().getCounselId());

        education = educationRepository.save(education);
        return new EducationDTO(education.getEducationId(), education.getEducationTitle(), education.getEducationDescription(), education.getCounselId());
    }
}
