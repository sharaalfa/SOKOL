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
    private static final String REDIRECT_TO_LIST = "redirect:/requestType/list";
    private static final String LIST_MAP = "/requestType/list";
    private static final String FORM_VIEW = "requestType";
    private static final String LIST_VIEW = "requestTypes";

    final private RequestTypeDao requestTypeDao;

    @Autowired
    public RequestTypeController(RequestTypeDao requestTypeDao) {
        this.requestTypeDao = requestTypeDao;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("requestTypes", requestTypeDao.getAll());
        return LIST_VIEW;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable int id, Model model) {
        model.addAttribute("requestType", requestTypeDao.getById(id));
        configureCancelUrl(model);
        return FORM_VIEW;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, RequestType requestType) {
        RequestType updated = requestTypeDao.getById(id);
        updated.setTitle(requestType.getTitle());
        updated.setDescription(requestType.getDescription());
        updated.setUpdatedDate(requestType.getUpdatedDate());
        requestTypeDao.update(updated);
        return REDIRECT_TO_LIST;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showNew(Model model) {
        model.addAttribute("requestType", new RequestType());
        configureCancelUrl(model);
        return FORM_VIEW;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(RequestType requestType) {
        requestTypeDao.save(requestType);
        return REDIRECT_TO_LIST;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        requestTypeDao.delete(requestTypeDao.getById(id));
        return REDIRECT_TO_LIST;
    }

    private void configureCancelUrl(Model model) {
        model.addAttribute("cancelUrl", LIST_MAP);
    }
}
