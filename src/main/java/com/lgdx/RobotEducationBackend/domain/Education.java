package com.lgdx.RobotEducationBackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "education")
public class Education {
    @Id
    private String educationId;
    private String educationTitle;
    private String educationDescription;
    private String counselId;
}
