package com.lgdx.RobotEducationBackend.service;

import com.lgdx.RobotEducationBackend.dto.CustomerDTO;
import com.lgdx.RobotEducationBackend.repository.CustomerRepository;
import com.lgdx.RobotEducationBackend.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;


    @Transactional
    public CustomerDTO getOneCustomer(String customerId) {
        return CustomerDTO.from(customerRepository.findByCustomerId(customerId).orElseThrow(ResourceNotFoundException::new));
    }
}