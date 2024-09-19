package com.lgdx.RobotEducation.repository;

import com.lgdx.RobotEducation.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    // READ
    Optional<Customer> findByCustomerId(String customerId);
//    List<User> findByMemberNameContaining(String memberName);
//    List<User> findByMemberWarning(String memberWarning);

    // CREATE

    // UPDATE

    // DELETE
//    void deleteById(String memberId);
}
