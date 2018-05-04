package com.example.controller;

import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.IUserService;

@RestController
@RequestMapping(value = "/users")
public class UserController
{

    @Autowired
    private IUserService userService;

//    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int",paramType = "path"),
//            @ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "pwd", value = "password", required = true, dataType = "String")
//    })
    @RequestMapping(value = "/add/{id}/{name}/{pwd}", method = RequestMethod.GET)
    public User addUser(@PathVariable int id, @PathVariable String name,
                        @PathVariable String pwd)
    {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPwd(pwd);
        userService.saveUser(user);
        return user;
    }

    @RequestMapping(value = "/delete/{id}")
    public void deleteBook(@PathVariable int id)
    {
        userService.delete(id);
    }

    @RequestMapping(value = "/")
    public List<User> getBooks()
    {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}")
    public User getUser(@PathVariable int id)
    {
        User user = userService.findOne(id);
        return user;
    }

    @RequestMapping(value = "/search/name/{name}")
    public List<User> getBookByName(@PathVariable String name)
    {
        List<User> users = userService.findByName(name);
        return users;
    }

    @RequestMapping(value = "/search/pwd/{pwd}")
    public List<User> getInfoByPwd(@PathVariable String pwd)
    {

        List<User> users = userService.findByPassword(pwd);
        return users;
    }

}