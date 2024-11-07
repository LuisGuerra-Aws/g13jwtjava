package com.g3jwt.authjwt.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.g3jwt.authjwt.Entities.User;

@Repository
public interface UserRepository extends CrudRepository <User, Integer>{
    Optional <User> findByEmail(String email);

}
