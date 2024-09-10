package com.lgdx.RobotEducationBackend.exception;

public record ErrorDTO(
        String errorMessage
) {
    public static ErrorDTO of(String errorMessage) {
        return new ErrorDTO(errorMessage);
    }
}
