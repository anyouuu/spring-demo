package com.example.controller;


 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.servlet.ModelAndView;
 import com.example.db.UserDao;
 import com.example.model.UserVO;

 @Controller
 public class LoginController {

     @Autowired
     private UserDao userDao;
     @SuppressWarnings("unchecked")

     @RequestMapping(value="/select.do")
     public ModelAndView selectAll(){

         @SuppressWarnings("rawtypes")
         Map model=new HashMap();

         List<UserVO> userVO=userDao.find();

         model.put("uservo", userVO);

         return new ModelAndView("userInfo",model);
     }
 }
