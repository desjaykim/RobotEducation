package com.lgdx.RobotEducationBackend.dto;

import com.lgdx.RobotEducationBackend.domain.Education;
import io.swagger.v3.oas.annotations.media.Schema;

public record EducationDTO(
        @Schema(example = "교육1")
        String educationId,
        @Schema(example = "소음 줄이기 학습")
        String educationTitle,
        @Schema(example = "소음 줄이는 방법을 설명합니다.")
        String educationDescription,
        @Schema(example = "상담1")
        String counselId
) {

    public static EducationDTO of(String educationId, String educationTitle, String educationDescription, String counselId) {
        return new EducationDTO(educationId, educationTitle, educationDescription, counselId);
    }

    public static EducationDTO from(Education education) {
        return new EducationDTO(
                education.getEducationId(),
                education.getEducationTitle(),
                education.getEducationDescription(),
                education.getCounselId()
        );
    }

    public Education toEntity() {
        return Education.builder()
                .educationId(educationId)
                .educationTitle(educationTitle)
                .educationDescription(educationDescription)
                .counselId(counselId)
                .build();
    }
}
