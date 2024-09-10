package com.lgdx.RobotEducationBackend.dto;

import com.lgdx.RobotEducationBackend.domain.Recap;
import io.swagger.v3.oas.annotations.media.Schema;

public record RecapDTO(
        @Schema(example = "교육1")
        String recapId,
        @Schema(example = "소음 줄이기 학습")
        String recapTitle,
        @Schema(example = "소음 줄이는 방법을 설명합니다.")
        String recapDescription,
        @Schema(example = "상담1")
        String counselId
) {

    public static RecapDTO of(String recapId, String recapTitle, String recapDescription, String counselId) {
        return new RecapDTO(recapId, recapTitle, recapDescription, counselId);
    }

    public static RecapDTO from(Recap recap) {
        return new RecapDTO(
                recap.getRecapId(),
                recap.getRecapTitle(),
                recap.getRecapDescription(),
                recap.getCounselId()
        );
    }

    public Recap toEntity() {
        return Recap.builder()
                .recapId(recapId)
                .recapTitle(recapTitle)
                .recapDescription(recapDescription)
                .counselId(counselId)
                .build();
    }
}
