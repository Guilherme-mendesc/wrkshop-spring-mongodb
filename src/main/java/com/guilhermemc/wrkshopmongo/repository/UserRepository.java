package com.guilhermemc.wrkshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.guilhermemc.wrkshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
