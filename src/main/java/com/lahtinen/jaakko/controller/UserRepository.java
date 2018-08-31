package com.lahtinen.jaakko.controller;

import org.springframework.data.repository.CrudRepository;
import com.lahtinen.jaakko.data.*;

public interface UserRepository extends CrudRepository<User,Long> {

	User findByUsername(String username);
}
