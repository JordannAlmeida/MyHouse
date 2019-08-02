package com.controlhome.myhome.repository;

import com.controlhome.myhome.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserLogin(String userLogin);
}
