package com.lgdx.RobotEducationBackend.repository;

import com.lgdx.RobotEducationBackend.domain.Education;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EducationRepository extends MongoRepository<Education, String> {
}
