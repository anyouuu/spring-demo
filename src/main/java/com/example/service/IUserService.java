package com.example.service;

import com.example.model.User;
import java.util.List;


public interface IUserService {
    public List<User> findAll();

    public void saveUser(User book);

    public User findOne(Integer id);
 
    public void delete(Integer id);

    public List<User> findByName(String name);

    public List<User> findByPassword(String pwd);
}
