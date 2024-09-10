package com.lgdx.RobotEducationBackend.controller;

import com.lgdx.RobotEducationBackend.dto.CounselFeedbackDTO;
import com.lgdx.RobotEducationBackend.service.CounselFeedbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CounselFeedback", description = "CounselFeedback API")
@RestController
@RequestMapping("/counselfeedback")
@RequiredArgsConstructor
public class CounselFeedbackController {

    private final CounselFeedbackService counselFeedbackService;

    @Operation(summary = "Submit Counsel Feedback", description = "Submits counsel feedback for a counsel session")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Counsel Feedback submitted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PostMapping("/submit")
    public ResponseEntity<CounselFeedbackDTO> submitFeedback(@RequestBody CounselFeedbackDTO counselFeedbackDTO) {
        CounselFeedbackDTO savedCounselFeedback = counselFeedbackService.submitFeedback(counselFeedbackDTO);
        return new ResponseEntity<>(savedCounselFeedback, HttpStatus.CREATED);
    }
}
