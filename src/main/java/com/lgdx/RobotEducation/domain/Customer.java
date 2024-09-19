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
@Document(collection = "customer")
public class Customer {

    @Id
    private String customerId;
    private String customerPw;
    private String customerName;
    private String email;
    private String phoneNumber;
//    private String customerId;
//    private String customerPw;
//    private String customerName;
//    private String age;
//    private String location;
//    private String gender;
//    private String experience;

}
