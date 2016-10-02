package io.khasang.sokol.controller;

import io.khasang.sokol.dao.RequestTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestTypeController {
    @Autowired
    RequestTypeDao requestTypeDao;

    @RequestMapping(value = "requestTypes", method = RequestMethod.GET)
    public String requestTypes(Model model) {
        model.addAttribute("requestTypes", requestTypeDao.getAll());
        return "requestTypes";
    }
}
