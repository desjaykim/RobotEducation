package com.lgdx.RobotEducationBackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import com.lgdx.RobotEducationBackend.domain.Customer;

public record CustomerDTO(
        @Schema(example = "talk1")
        String customerId,
        @Schema(example = "lgdxschool")
        String customerPw,
        @Schema(example = "김오똑")
        String customerName,
        @Schema(example = "ohTalk@gmail.com")
        String email,
        @Schema(example = "010-1234-5678")
        String phoneNumber
) {

    public static CustomerDTO of(String customerId, String customerPw, String customerName, String email, String phoneNumber) {
        return new CustomerDTO(customerId, customerPw, customerName, email, phoneNumber);
    }

    public static CustomerDTO from(Customer customer) {
        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getCustomerPw(),
                customer.getCustomerName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }

    public Customer toEntity() {
        return Customer.builder()
                .customerId(customerId)
                .customerPw(customerPw)
                .customerName(customerName)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
