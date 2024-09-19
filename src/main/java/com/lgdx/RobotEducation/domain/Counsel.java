package com.lgdx.RobotEducation.domain;

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
@Document(collection = "counsel")
public class Counsel {
    @Id
    private String counselId;
    private Date counselDate;
    private String customerId;
    private String counselorId;
    private Integer level;
    private String reason;
    private String education;

}
