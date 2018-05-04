package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends UserJpaRepository {
    List<User> findByNameAndPwd(String name, String pwd);

    List<User> findByName(String name);

}
