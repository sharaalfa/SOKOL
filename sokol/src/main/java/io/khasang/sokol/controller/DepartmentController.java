package io.khasang.sokol.controller;

import io.khasang.sokol.dao.DepartmentDao;
import io.khasang.sokol.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/department")
public class DepartmentController {
    private static final String REDIRECT_TO_LIST = "redirect:/department/list";
    private static final String LIST_MAP = "/department/list";
    private static final String FORM_VIEW = "departmentForm";
    private static final String LIST_VIEW = "departmentList";

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(final Model model) {
        model.addAttribute("departmentList", departmentDao.getAll());
        return LIST_VIEW;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(final Model model, @PathVariable int id) {
        model.addAttribute("cancelUrl", LIST_MAP);
        model.addAttribute("department", departmentDao.getById(id));
        return FORM_VIEW;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, final Department department) {
        department.setId(id);
        departmentDao.update(department);
        return REDIRECT_TO_LIST;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showNew(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("cancelUrl", LIST_MAP);
        return FORM_VIEW;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Department department) {
        departmentDao.save(department);
        return REDIRECT_TO_LIST;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteRequestType(@PathVariable int id) {
        departmentDao.delete(departmentDao.getById(id));
        return REDIRECT_TO_LIST;
    }
}
