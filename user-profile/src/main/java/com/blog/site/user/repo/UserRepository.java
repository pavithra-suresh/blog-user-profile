package com.blog.site.user.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.site.user.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
