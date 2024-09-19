package com.lgdx.RobotEducation.service;

import com.lgdx.RobotEducation.domain.CounselFeedback;
import com.lgdx.RobotEducation.dto.CounselFeedbackDTO;
import com.lgdx.RobotEducation.repository.CounselFeedbackRepository;
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
