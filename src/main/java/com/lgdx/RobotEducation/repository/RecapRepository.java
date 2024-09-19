package com.lgdx.RobotEducation.repository;

import com.lgdx.RobotEducation.domain.Recap;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecapRepository extends MongoRepository<Recap, String> {
}
