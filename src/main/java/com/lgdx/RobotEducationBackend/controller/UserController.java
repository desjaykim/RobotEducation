package com.lgdx.RobotEducationBackend.controller;

import com.lgdx.RobotEducationBackend.service.UserService;
import com.lgdx.RobotEducationBackend.dto.UserDTO;
import com.lgdx.RobotEducationBackend.exception.ErrorDTO;
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

@Tag(name = "User", description = "User API")
@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get/{userId}")
    public ResponseEntity<UserDTO> getOneUser(@Parameter(description = "멤버 인덱스")
                                                  @PathVariable String userId) {
        log.info("getOneUser : userId = {}", userId);
        return new ResponseEntity<>(userService.getOneUser(userId), HttpStatus.OK);
    }
}