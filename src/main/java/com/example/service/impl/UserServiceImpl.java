package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.repository.UserJpaRepository;
import com.example.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll()
    {
        return userJpaRepository.findAll();
    }

    public List<User> findByName(String name)
    {

        List<User> userList3 = userRepository.findByNameAndPwd(name, "3");

        System.out.println("userList3:" + userList3);
        return userRepository.findByName(name);
    }

    public void saveUser(User book)
    {
        userJpaRepository.save(book);
    }

    @Cacheable("users")
    public User findOne(long id)
    {
        System.out.println("Cached Pages");
        return userJpaRepository.findOne(id);
    }

    public void delete(long id)
    {
        userJpaRepository.delete(id);
    }
}