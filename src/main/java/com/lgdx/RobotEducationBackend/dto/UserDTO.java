package com.lgdx.RobotEducationBackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import com.lgdx.RobotEducationBackend.domain.User;

import java.time.LocalDate;
import java.util.List;

public record UserDTO(
        @Schema(example = "1")
        String userId
) {

    public static UserDTO of(String userId) {
        return new UserDTO(userId);
    }

    public static UserDTO from(User user) {
        return new UserDTO(
                user.getUserId()
        );
    }

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .build();
    }
}
