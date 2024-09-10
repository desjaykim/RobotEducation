package com.lgdx.RobotEducationBackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CounselRequestDTO {
    private CounselDTO counselDTO;
    private CounselInfoDTO counselInfoDTO;

    public CounselRequestDTO(CounselDTO counselDTO, CounselInfoDTO counselInfoDTO) {
        this.counselDTO = counselDTO;
        this.counselInfoDTO = counselInfoDTO;
    }
}
