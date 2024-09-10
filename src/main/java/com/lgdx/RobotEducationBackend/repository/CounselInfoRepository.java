package com.lgdx.RobotEducationBackend.repository;
import com.lgdx.RobotEducationBackend.domain.CounselInfo;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CounselInfoRepository extends MongoRepository<CounselInfo, String> {
}
