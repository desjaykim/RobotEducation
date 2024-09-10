package com.lgdx.RobotEducationBackend.controller;

import com.lgdx.RobotEducationBackend.dto.CounselDTO;
import com.lgdx.RobotEducationBackend.dto.CounselInfoDTO;
import com.lgdx.RobotEducationBackend.dto.CounselRequestDTO;
import com.lgdx.RobotEducationBackend.service.CounselService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Counsel", description = "Counsel API")
@Slf4j
@RestController
@RequestMapping("/counsel")
@RequiredArgsConstructor
public class CounselController {

    private final CounselService counselService;

    @Operation(summary = "Save counsel information and content", description = "Save the counsel details and content to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Counsel saved"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/save")
    public ResponseEntity<CounselDTO> saveCounsel(
            @RequestBody CounselRequestDTO counselRequestDTO
    ) {
        // 서비스에서 상담 및 상담 내용 저장
        CounselDTO savedCounsel = counselService.saveCounsel(
                counselRequestDTO.getCounselDTO(),
                counselRequestDTO.getCounselInfoDTO()
        );

        return new ResponseEntity<>(savedCounsel, HttpStatus.CREATED);
    }
}
