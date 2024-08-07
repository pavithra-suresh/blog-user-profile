package com.blog.site.user.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.site.user.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
