package com.lgdx.RobotEducationBackend.controller;

import com.lgdx.RobotEducationBackend.service.CounselService;
import com.lgdx.RobotEducationBackend.dto.CounselDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Tag(name = "Counsel", description = "Counsel API")
@Slf4j
@RestController
@RequestMapping("/counsel")
@RequiredArgsConstructor
public class CounselController {

    private final CounselService counselService;

    @Operation(summary = "Save counsel information", description = "Save the counsel content to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Counsel saved"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/save")
    public ResponseEntity<CounselDTO> saveCounsel(
            @Parameter(description = "Counsel ID") @RequestParam String counselId,
            @Parameter(description = "Counsel DATE") @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date counselDate,
            @Parameter(description = "Customer ID") @RequestParam String customerId,
            @Parameter(description = "Counselor ID") @RequestParam String counselorId,
            @Parameter(description = "Level") @RequestParam Integer level,
            @Parameter(description = "Reason") @RequestParam String reason,
            @Parameter(description = "Education") @RequestParam String education) {
        return new ResponseEntity<>(counselService.saveCounsel(counselId, counselDate, customerId, counselorId, level, reason, education), HttpStatus.CREATED);
    }
}