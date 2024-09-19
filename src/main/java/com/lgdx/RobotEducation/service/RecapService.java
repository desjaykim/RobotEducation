package com.lgdx.RobotEducation.service;

import com.lgdx.RobotEducation.domain.Recap;
import com.lgdx.RobotEducation.dto.RecapDTO;
import com.lgdx.RobotEducation.repository.RecapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecapService {

    private final RecapRepository recapRepository;

    public RecapDTO addRecap(RecapDTO recapDTO) {
        Recap recap = new Recap();
        recap.setRecapTitle(recapDTO.toEntity().getRecapTitle());
        recap.setRecapDescription(recapDTO.toEntity().getRecapDescription());
        recap.setCounselId(recapDTO.toEntity().getCounselId());

        recap = recapRepository.save(recap);
        return new RecapDTO(recap.getRecapId(), recap.getRecapTitle(), recap.getRecapDescription(), recap.getCounselId());
    }
}
