package com.lgdx.RobotEducation.controller;


import com.lgdx.RobotEducation.dto.RecapDTO;
import com.lgdx.RobotEducation.service.RecapService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Recap", description = "Recap API")
@Slf4j
@RestController
@RequestMapping("/recap")
@RequiredArgsConstructor
public class RecapController {

    private final RecapService recapService;

    @Operation(summary = "Add Recap", description = "Adds recap to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Recap added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PostMapping("/add")
    public ResponseEntity<RecapDTO> addRecap(@RequestBody RecapDTO recapDTO) {
        RecapDTO savedRecap = recapService.addRecap(recapDTO);
        return new ResponseEntity<>(savedRecap, HttpStatus.CREATED);
    }
}
