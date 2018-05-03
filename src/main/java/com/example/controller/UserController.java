package com.example.controller;


 import java.util.Collection;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.stream.Collectors;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.data.domain.Page;
 import org.springframework.data.domain.PageImpl;
 import org.springframework.data.domain.PageRequest;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 import org.springframework.web.servlet.ModelAndView;

 import com.example.model.User;
 import com.example.dao.*;
 import com.example.dto.*;
 import com.example.util.*;


 @RestController
 @RequestMapping("/api/")
 public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("member-management")
    public String listMember() {
        return "xxx";
    }

//    public Msg<Page<OrgMember>> listMember() {
//
//        String nameString = "ss";
//        User parent = userRepo.findByName(nameString);
//
//        if (parent == null) return Msg.err("user does not exist");
//
//        Collection<User> children = parent.getChildren();
//
//        // add parent self
//        children.add(parent);
//
//        List<OrgMember> members =
//                children
//                        .stream()
//                        .map(
//                                u -> {
//                                    OrgMember m = new OrgMember();
//                                    m.setUserName(u.getName());
//                                    m.setEmail(u.getEmail());
//                                    return m;
//                                })
//                        .collect(Collectors.toList());
//
//        PageRequest page = new PageRequest(0, members.size());
//        return Msg.ok(new PageImpl<>(members, page, members.size()));
//    }

 }
