package com.lgdx.RobotEducation.repository;
import com.lgdx.RobotEducation.domain.CounselInfo;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CounselInfoRepository extends MongoRepository<CounselInfo, String> {
}
