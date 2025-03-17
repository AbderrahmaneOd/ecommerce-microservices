package com.simpleproject.userservice.repository;

import com.simpleproject.userservice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);

    @Query("{'$and': [ " +
            "{'username': {'$regex': ?0, '$options': 'i'}}, " +
            "{'email': {'$regex': ?1, '$options': 'i'}} " +
            "]}")
    Page<User> findByUsernameLikeAndEmailLike(String username, String email, Pageable pageable);
}
