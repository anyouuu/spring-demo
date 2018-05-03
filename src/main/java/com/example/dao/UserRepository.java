package com.example.dao;


import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);

    @Query(value = "select  u from t_user u where u.id = ?1", nativeQuery = true)
    Set<User> findChildren(Integer parent);

    boolean existsByName(String name);
}
