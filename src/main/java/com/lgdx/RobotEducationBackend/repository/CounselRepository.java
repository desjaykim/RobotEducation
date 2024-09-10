package com.lgdx.RobotEducationBackend.repository;
import com.lgdx.RobotEducationBackend.domain.Counsel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CounselRepository extends MongoRepository<Counsel, String> {
}
