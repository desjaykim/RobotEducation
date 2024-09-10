package com.lgdx.RobotEducationBackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import com.lgdx.RobotEducationBackend.domain.Customer;

public record CustomerDTO(
        @Schema(example = "1")
        String customerId
) {

    public static CustomerDTO of(String customerId) {
        return new CustomerDTO(customerId);
    }

    public static CustomerDTO from(Customer customer) {
        return new CustomerDTO(
                customer.getCustomerId()
        );
    }

    public Customer toEntity() {
        return Customer.builder()
                .customerId(customerId)
                .build();
    }
}
