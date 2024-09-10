package com.lgdx.RobotEducationBackend.repository;
import com.lgdx.RobotEducationBackend.domain.CounselFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CounselFeedbackRepository extends MongoRepository<CounselFeedback, String> {
}
