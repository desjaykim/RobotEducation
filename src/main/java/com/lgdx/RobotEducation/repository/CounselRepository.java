package com.lgdx.RobotEducation.repository;
import com.lgdx.RobotEducation.domain.Counsel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CounselRepository extends MongoRepository<Counsel, String> {
}
