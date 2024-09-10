package com.lgdx.RobotEducationBackend.service;

import com.lgdx.RobotEducationBackend.domain.CounselFeedback;
import com.lgdx.RobotEducationBackend.dto.CounselFeedbackDTO;
import com.lgdx.RobotEducationBackend.repository.CounselFeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CounselFeedbackService {

    private final CounselFeedbackRepository counselFeedbackRepository;

    public CounselFeedbackDTO submitFeedback(CounselFeedbackDTO counselFeedbackDTO) {
        CounselFeedback counsleFeedback = new CounselFeedback();
        counsleFeedback.setCounselId(counselFeedbackDTO.toEntity().getCounselId());
        counsleFeedback.setRating(counselFeedbackDTO.toEntity().getRating());
        counsleFeedback.setFeedback(counselFeedbackDTO.toEntity().getFeedback());
        counsleFeedback.setFeedbackDate(new Date());

        counsleFeedback = counselFeedbackRepository.save(counsleFeedback);
        return new CounselFeedbackDTO(counsleFeedback.getFeedbackId(), counsleFeedback.getCounselId(), counsleFeedback.getRating(), counsleFeedback.getFeedback(), counsleFeedback.getFeedbackDate());
    }
}
