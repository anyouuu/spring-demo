package com.example.controller;

import java.util.List;

import com.example.exception.ExceptionHandle;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.model.User;
import com.example.service.IUserService;

@RestController
@RequestMapping(value = "/users")
public class UserController
{

    @Autowired
    private ExceptionHandle exceptionHandle;

    @Autowired
    private IUserService userService;

//    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int",paramType = "path"),
//            @ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "pwd", value = "password", required = true, dataType = "String")
//    })
    @RequestMapping(value = "/add/{name}/{pwd}", method = RequestMethod.POST)
    public User addUser( User u)
    {
        User user = new User();
        user.setId(10);
        user.setName(u.getName());
        user.setPwd(u.getPwd());
        user.setAge(u.getAge());
        userService.saveUser(user);
        System.out.println("out = " + user.getId());
        return user;
    }

    private User save(int id ,String name ,String pwd) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPwd(pwd);
        userService.saveUser(user);
        return user;
    }

    @RequestMapping(value = "/add/{id}/{name}/{pwd}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable int id, @PathVariable String name,
                        @PathVariable String pwd)
    {
        return this.save(id, name, pwd);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable int id)
    {
        userService.delete(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getBooks()
    {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable int id)
    {
        User user = userService.findOne(id);
        return user;
    }

    @GetMapping(value = "/testAfterReturning01/{str}")
    public String testAfterReturning01(String keys) {
        return "返回值 keys=:"+keys;
    }


    @GetMapping(value = "/testAfterReturning")
    public Integer testAfterReturning (Integer key) {
        try {
            if (key.equals(11)) {
                return 11;
            } else {
                return 0;
            }
        } catch (Exception e) {
            exceptionHandle.handler(e);
            System.out.println("xxxx");
        }
        return key;
    }

    @RequestMapping(value = "/search/name/{name}", method = RequestMethod.GET)
    public List<User> getBookByName(@PathVariable String name)
    {
        List<User> users = userService.findByName(name);
        return users;
    }

    @RequestMapping(value = "/search/pwd/{pwd}", method = RequestMethod.GET)
    public List<User> getInfoByPwd(@PathVariable String pwd)
    {

        List<User> users = userService.findByPassword(pwd);
        return users;
    }

}