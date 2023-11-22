package com.mysql.accessingdatamysql.repository;

import com.mysql.accessingdatamysql.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
