package com.guilhermemc.wrkshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.guilhermemc.wrkshopmongo.domain.Post;
import com.guilhermemc.wrkshopmongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
