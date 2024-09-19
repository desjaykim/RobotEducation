package com.lgdx.RobotEducation.controller;

import com.lgdx.RobotEducation.exception.ErrorDTO;
import com.lgdx.RobotEducation.service.CustomerService;
import com.lgdx.RobotEducation.dto.CustomerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Customer", description = "Customer API")
@Slf4j
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Get Customer", description = "고객 인덱스로 멤버 한명 검색하기")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "고객 검색 성공", content = @Content(schema = @Schema(implementation = CustomerDTO.class))),
            @ApiResponse(responseCode = "404", description = "고객이 존재하지 않습니다.", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
    })

    @GetMapping("/get/{customerId}")
    public ResponseEntity<CustomerDTO> getOneCustomer(@Parameter(description = "고객 인덱스")
                                                  @PathVariable String customerId) {
        log.info("getOneCustomer : customerId = {}", customerId);
        return new ResponseEntity<>(customerService.getOneCustomer(customerId), HttpStatus.OK);
    }

    @Operation(summary = "Get All Customers", description = "모든 고객 검색하기")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "고객 리스트 검색 성공", content = @Content(array = @ArraySchema(schema = @Schema(implementation = CustomerDTO.class)))),
            @ApiResponse(responseCode = "404", description = "고객 리스트가 존재하지 않습니다.", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
    })
    @GetMapping("/get/all")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        log.info("getAllCustomers");
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }
}