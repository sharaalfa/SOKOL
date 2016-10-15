package io.khasang.sokol.controller;

import io.khasang.sokol.dao.RequestTypeDao;
import io.khasang.sokol.entity.RequestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping(value = "/requestType")
public class RequestTypeController {
    private static final String LIST_VIEW = "redirect:/requestType/list";
    private static final String EDIT_VIEW = "requestTypeForm";

    @Autowired
    RequestTypeDao requestTypeDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showRequestTypes(Model model) {
        model.addAttribute("requestTypes", requestTypeDao.getAll());
        return "requestTypes";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editRequestType(@PathVariable int id, Model model) {
        model.addAttribute("requestType", requestTypeDao.getById(id));
        return EDIT_VIEW;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateRequestType(@PathVariable int id, RequestType requestType) {
        requestType.setId(id);
        requestType.setUpdatedDate(new Date());
        requestTypeDao.update(requestType);
        return LIST_VIEW;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newRequestType() {
        return EDIT_VIEW;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveRequestType(RequestType requestType) {
        Date now = new Date();
        requestType.setCreatedDate(now);
        requestType.setUpdatedDate(now);
        requestTypeDao.save(requestType);
        return LIST_VIEW;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteRequestType(@PathVariable int id) {
        requestTypeDao.delete(requestTypeDao.getById(id));
        return LIST_VIEW;
    }
}
