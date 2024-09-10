package com.lgdx.RobotEducationBackend.dto;

import com.lgdx.RobotEducationBackend.domain.CounselInfo;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record CounselInfoDTO(
        @Schema(example = "상담1")
        String counselId,
        @Schema(example = "저녁에 돌리는데 소음이 너무 커서 시끄러워요.")
        List<String> contents,
        @Schema(example = "[시끄러움, 소음]")
        List<String> keywords
) {

    public static CounselInfoDTO of(
            String counselId,
            List<String> contents,
            List<String> keywords) {
        return new CounselInfoDTO(counselId, contents, keywords);
    }

    public static CounselInfoDTO from(CounselInfo counselInfo) {
        return new CounselInfoDTO(
                counselInfo.getCounselId(),
                counselInfo.getContents(),
                counselInfo.getKeyword()
        );
    }

    public CounselInfo toEntity() {
        return CounselInfo.builder()
                .counselId(counselId)
                .contents(contents)
                .keyword(keywords)
                .build();
    }
}
