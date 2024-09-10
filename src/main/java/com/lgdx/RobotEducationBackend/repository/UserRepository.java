package com.lgdx.RobotEducationBackend.repository;

import com.lgdx.RobotEducationBackend.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    // READ
    Optional<User> findByUserId(String userId);
//    List<User> findByMemberNameContaining(String memberName);
//    List<User> findByMemberWarning(String memberWarning);

    // CREATE

    // UPDATE

    // DELETE
//    void deleteById(String memberId);
}
