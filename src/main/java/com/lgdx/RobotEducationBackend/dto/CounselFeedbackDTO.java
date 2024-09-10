package com.lgdx.RobotEducationBackend.dto;

import com.lgdx.RobotEducationBackend.domain.Counsel;
import com.lgdx.RobotEducationBackend.domain.CounselFeedback;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public record CounselFeedbackDTO(
        @Schema(example = "1")
        String feedbackId,
        @Schema(example = "상담1")
        String counselId,
        @Schema(example = "5")
        Integer rating,
        @Schema(example = "좋은 상담이었습니다")
        String feedback,
        @Schema(example = "2024-09-10")
        Date feedbackDate
) {

    public static CounselFeedbackDTO of(
            String feedbackId,
            String counselId,
            Integer rating,
            String feedback,
            Date feedbackDate) {
        return new CounselFeedbackDTO(feedbackId, counselId, rating, feedback, feedbackDate);
    }

    public static CounselFeedbackDTO from(CounselFeedback counselFeedback) {
        return new CounselFeedbackDTO(
                counselFeedback.getFeedbackId(),
                counselFeedback.getCounselId(),
                counselFeedback.getRating(),
                counselFeedback.getFeedback(),
                counselFeedback.getFeedbackDate()
        );
    }

    public CounselFeedback toEntity() {
        return CounselFeedback.builder()
                .feedbackId(feedbackId)
                .counselId(counselId)
                .rating(rating)
                .feedback(feedback)
                .feedbackDate(feedbackDate)
                .build();
    }
}
