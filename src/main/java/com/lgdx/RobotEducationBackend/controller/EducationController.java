package com.lgdx.RobotEducationBackend.controller;


import com.lgdx.RobotEducationBackend.dto.EducationDTO;
import com.lgdx.RobotEducationBackend.service.EducationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Education", description = "Education API")
@Slf4j
@RestController
@RequestMapping("/education")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @Operation(summary = "Add Education", description = "Adds education to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Education added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PostMapping("/add")
    public ResponseEntity<EducationDTO> addEducation(@RequestBody EducationDTO educationDTO) {
        EducationDTO savedEducation = educationService.addEducation(educationDTO);
        return new ResponseEntity<>(savedEducation, HttpStatus.CREATED);
    }
}
