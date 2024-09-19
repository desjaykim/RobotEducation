package com.lgdx.RobotEducation.service;

import com.lgdx.RobotEducation.domain.Customer;
import com.lgdx.RobotEducation.dto.CustomerDTO;
import com.lgdx.RobotEducation.exception.ListNotFoundElementException;
import com.lgdx.RobotEducation.repository.CustomerRepository;
import com.lgdx.RobotEducation.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;


    @Transactional
    public CustomerDTO getOneCustomer(String customerId) {
        return CustomerDTO.from(customerRepository.findByCustomerId(customerId).orElseThrow(ResourceNotFoundException::new));
    }

    @Transactional
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();

        if (customers.isEmpty()) {
            throw new ListNotFoundElementException();
        }

        List<CustomerDTO> customerDTOs = new ArrayList<>();
        for (Customer customer : customers) {
            customerDTOs.add(CustomerDTO.from(customer));
        }

        return customerDTOs;
    }
}