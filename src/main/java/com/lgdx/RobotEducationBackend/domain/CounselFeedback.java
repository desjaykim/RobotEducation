package com.lgdx.RobotEducationBackend.domain;

import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "counsel_feedback")
public class CounselFeedback {

    @Id
    private String feedbackId;
    private String counselId;
    private Integer rating;
    private String feedback;
    private Date feedbackDate;
}
