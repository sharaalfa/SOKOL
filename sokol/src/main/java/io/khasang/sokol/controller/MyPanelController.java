package io.khasang.sokol.controller;


import io.khasang.sokol.dao.RequestDao;
import io.khasang.sokol.dao.RoleDao;
import io.khasang.sokol.dao.UserDao;
import io.khasang.sokol.entity.Request;
import io.khasang.sokol.model.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class MyPanelController {
    private static final Logger log = Logger.getLogger("MyPanel");
    @Autowired
    CreateTable createTable;
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    RequestDao requestDao;

    @RequestMapping("/mypanel")
    public String hello(Model model){
        requestDao.getAll();
        SecurityContext context = SecurityContextHolder.getContext();
        String userName = context.getAuthentication().getName();
        List<Request> myRequests =  requestDao.getMyRequests(userName);
        List<Request> forMeRequests =  requestDao.getRequestsForMe(userName);
        model.addAttribute("myRequests", myRequests);
        model.addAttribute("forMeRequests", forMeRequests);
        return "mypanel";
    }
}
