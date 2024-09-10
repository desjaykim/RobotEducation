package com.lgdx.RobotEducationBackend.controller;

import com.lgdx.RobotEducationBackend.service.CustomerService;
import com.lgdx.RobotEducationBackend.dto.CustomerDTO;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Customer", description = "Customer API")
@Slf4j
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get/{customerId}")
    public ResponseEntity<CustomerDTO> getOneCustomer(@Parameter(description = "고객 인덱스")
                                                  @PathVariable String customerId) {
        log.info("getOneCustomer : customerId = {}", customerId);
        return new ResponseEntity<>(customerService.getOneCustomer(customerId), HttpStatus.OK);
    }
}