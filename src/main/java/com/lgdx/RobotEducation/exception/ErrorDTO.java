package com.lgdx.RobotEducation.exception;

public record ErrorDTO(
        String errorMessage
) {
    public static ErrorDTO of(String errorMessage) {
        return new ErrorDTO(errorMessage);
    }
}
