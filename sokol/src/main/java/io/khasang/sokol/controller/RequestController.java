package io.khasang.sokol.controller;

import io.khasang.sokol.dao.*;
import io.khasang.sokol.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.jws.soap.SOAPBinding;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.bouncycastle.asn1.eac.CertificateBody.requestType;


/**
 * Created by Andrey on 02.10.2016.
 */
@Controller
public class RequestController {
    @Autowired
    RequestDao requestDao;
    @Autowired
    RequestTypeDao requestTypeDao;
    @Autowired
    RequestStatusDao requestStatusDao;

    @Autowired
    UserDao userDao;

    @Autowired
    TempDao tempDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping(value = "/requestList", method = RequestMethod.GET)
    public String requestListPage(Model requestListModel){
        List<Request> requestAll =  requestDao.getAll();
        requestListModel.addAttribute("requestAll", requestAll);
        return "requestList";
    }

    @RequestMapping(value = "/requestList/delete", method = RequestMethod.GET)
    public String delRequestPage(Model delRequest, @RequestParam("idRequest") String idRequest){
        Request request =  requestDao.getByRequestId(Integer.parseInt(idRequest));
        requestDao.delete(request);
        delRequest.addAttribute("request", request);
        return "redirect:/listRequest";
    }


    @RequestMapping(value = "/requestList/add", method = RequestMethod.GET)
    public String requestAddPage(Model requestAddModel){
        List<RequestType> requestTypeAll =  requestTypeDao.getAll();
        requestAddModel.addAttribute("requestTypeAll", requestTypeAll);
        List<Department> departmentAll = departmentDao.getAll();
        requestAddModel.addAttribute("departmentAll", departmentAll);
        return "requestAdd";
    }

    @RequestMapping(value = "/requestList/add", method = RequestMethod.POST)
    public String requestAdd(@RequestParam("name") String name,
                                          @RequestParam("description") String description,
                                          @RequestParam("idrequest") String idrequest,
                                          @RequestParam("iddepartment") String iddepartment){
        ModelAndView model = new ModelAndView();
        Request request = new Request();
        request.setTitle(name);
        request.setDescription(description);
        RequestStatus status =  requestStatusDao.getById(1);
        request.setStatus(status);
        request.setVersion(1);
        request.setCreatedDate(new Date());
        RequestType requestType =  requestTypeDao.getById(Integer.parseInt(idrequest));
        request.setRequestType(requestType);
        Department department = departmentDao.getById(Integer.parseInt(iddepartment));
        request.setDepartment(department);
        SecurityContext context = SecurityContextHolder.getContext();
        request.setCreatedBy(context.getAuthentication().getName());
        request.setUpdatedBy(context.getAuthentication().getName());
        requestDao.save(request);
        model.setViewName("requestAdd");
        return "redirect:/requestList";
    }

    // добавление запроса на редактирование
    @RequestMapping(value = "/addRequestPerformer", method = RequestMethod.GET)
    public String addRequestPerformerPage(Model addRequestPerformer, @RequestParam("idRequest") String idRequest){
        Request request =  requestDao.getByRequestId(Integer.parseInt(idRequest));
        addRequestPerformer.addAttribute("request", request);
        List<RequestType> requestTypes =  requestTypeDao.getAll();
        addRequestPerformer.addAttribute("requestTypes", requestTypes);
        List<Department> departments = departmentDao.getAll();
        addRequestPerformer.addAttribute("departments", departments);
        return "addRequestPerformer";
    }

    @RequestMapping(value = "/addRequestPerformer", method = RequestMethod.POST)
    public String  addRequestPerformer(@RequestParam("idrequest") String idrequest,
                                            @RequestParam("name") String name,
                                            @RequestParam("description") String description,
                                            @RequestParam("dateCreator") String dateCreator,
                                            @RequestParam("creator") String creator,
                                            @RequestParam("idrequesttypes") String idrequesttypes,
                                            @RequestParam("iddepartment") String iddepartment){
        ModelAndView model = new ModelAndView();
        Request request = requestDao.getByRequestId(Integer.parseInt(idrequest));
        request.setTitle(name);
        request.setDescription(description);
        RequestStatus status = requestStatusDao.getById(2);
        request.setStatus(status);
       // request.setVersion(1);
        request.setUpdatedDate(new Date());
        RequestType requestType =  requestTypeDao.getById(Integer.parseInt(idrequesttypes));
        request.setRequestType(requestType);
        request.setCreatedBy(creator);
        Department department = departmentDao.getById(Integer.parseInt(iddepartment));
        request.setDepartment(department);
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
               Date date= format.parse(dateCreator);
            request.setCreatedDate(date);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        SecurityContext context = SecurityContextHolder.getContext();
        request.setUpdatedBy(context.getAuthentication().getName());
        requestDao.update(request);
        model.setViewName("addRequestPerformer");
        return "redirect:/listRequest";
    }
}
/*              Temp temp = tempDao.getById(Integer.parseInt(idRequest));
        temp.setName(description);
     //   temp.setCreatedBy("CreatedBy2");
        temp.setCreatedBy(dateCreator);
        temp.setUpdatedDate(new Date());
        tempDao.update(temp);*/