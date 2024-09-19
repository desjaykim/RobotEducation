package com.lgdx.RobotEducation.repository;
import com.lgdx.RobotEducation.domain.CounselFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CounselFeedbackRepository extends MongoRepository<CounselFeedback, String> {
}
