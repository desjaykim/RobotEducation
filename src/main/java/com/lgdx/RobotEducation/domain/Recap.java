package com.lgdx.RobotEducation.domain;

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
@Document(collection = "recap")
public class Recap {
    @Id
    private String recapId;
    private String recapTitle;
    private String recapDescription;
    private String counselId;
}
