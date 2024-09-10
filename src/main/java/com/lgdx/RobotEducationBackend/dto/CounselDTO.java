package com.lgdx.RobotEducationBackend.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import com.lgdx.RobotEducationBackend.domain.Counsel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record CounselDTO(
        @Schema(example = "상담1")
        String counselId,
        @Schema(example = "2024.08.10")
        Date counselDate,
        @Schema(example = "talk1")
        String customerId,
        @Schema(example = "상담사1")
        String counselorId,
        @Schema(example = "2")
        Integer level,
        @Schema(example = "어플")
        String reason,
        @Schema(example = "저소음모드")
        String education

) {

    public static CounselDTO of(String counselId, Date counselDate, String customerId, String counselorId, Integer level, String reason, String education) {
        return new CounselDTO(counselId, counselDate, customerId, counselorId, level, reason, education);
    }

    public static CounselDTO from(Counsel counsel) {
        return new CounselDTO(
                counsel.getCounselId(),
                counsel.getCounselDate(),
                counsel.getCustomerId(),
                counsel.getCounselorId(),
                counsel.getLevel(),
                counsel.getReason(),
                counsel.getEducation()
        );
    }
    public Counsel toEntity() {
        return Counsel.builder()
                .counselId(counselId)
                .counselDate(counselDate)
                .customerId(customerId)
                .counselorId(counselorId)
                .level(level)
                .reason(reason)
                .education(education)
                .build();
    }
}
