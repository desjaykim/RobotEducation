package com.lgdx.RobotEducationBackend.repository;

import com.lgdx.RobotEducationBackend.domain.Recap;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecapRepository extends MongoRepository<Recap, String> {
}
