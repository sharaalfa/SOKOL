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

    @RequestMapping(value = "/listRequest", method = RequestMethod.GET)
    public String listRequestPage(Model listRequest){
        List<Request> listRequests =  requestDao.getAll();
        listRequest.addAttribute("listRequests", listRequests);
        return "listRequest";
    }

    @RequestMapping(value = "/listRequest/delete", method = RequestMethod.GET)
    public String delRequestPage(Model delRequest, @RequestParam("idRequest") String idRequest){
        Request request =  requestDao.getByRequestId(Integer.parseInt(idRequest));
        requestDao.delete(request);
        delRequest.addAttribute("request", request);
        return "redirect:/listRequest";
    }

/*
    @RequestMapping(value = "/listRequest/add", method = RequestMethod.GET)
    public String addRequestCreatorPage(Model addRequestCreator){
        List<RequestType> requestTypes =  requestTypeDao.getAll();
        List listTitleRequestTypes = new ArrayList();
        for (RequestType requestType : requestTypes
             ) {listTitleRequestTypes.add(requestType.getTitle());
        }
        addRequestCreator.addAttribute("listTitleRequestTypes", listTitleRequestTypes);
        return "addRequestCreator";
    }
*/

    @RequestMapping(value = "/addRequestCreator", method = RequestMethod.GET)
    public String addRequestCreatorPage(Model addRequestCreator){
        List<RequestType> requestTypes =  requestTypeDao.getAll();
        addRequestCreator.addAttribute("requestTypes", requestTypes);
        List<User> users =  userDao.getAll();
        addRequestCreator.addAttribute("users", users);
        return "addRequestCreator";
    }


    @RequestMapping(value = "/addRequestCreator", method = RequestMethod.POST)
    public String addRequestCreator(@RequestParam("name") String name,
                                          @RequestParam("description") String description,
                                          @RequestParam("idrequest") String idrequest,
                                          @RequestParam("iduser") String iduser){
        ModelAndView model = new ModelAndView();
        Request request = new Request();
        request.setTitle(name);
        request.setDescription(description);

      //  request.setCreatedBy(creator);
        RequestStatus status =  requestStatusDao.getById(1);
        request.setStatus(status);
        request.setVersion(1);
        request.setCreatedDate(new Date());
        RequestType requestType =  requestTypeDao.getById(Integer.parseInt(idrequest));
        request.setRequestType(requestType);

        User user = userDao.getById(Integer.parseInt(iduser));
        request.setAssignedTo(user);

        SecurityContext context = SecurityContextHolder.getContext();
        request.setCreatedBy(context.getAuthentication().getName());
        request.setUpdatedBy(context.getAuthentication().getName());
        requestDao.save(request);
        model.setViewName("addRequestCreator");
        return "redirect:/listRequest";
    }

    // добавление запроса на редактирование
    @RequestMapping(value = "/addRequestPerformer", method = RequestMethod.GET)
    public String addRequestPerformerPage(Model addRequestPerformer, @RequestParam("idRequest") String idRequest){
        Request request =  requestDao.getByRequestId(Integer.parseInt(idRequest));
        addRequestPerformer.addAttribute("request", request);
        List<RequestType> requestTypes =  requestTypeDao.getAll();
        addRequestPerformer.addAttribute("requestTypes", requestTypes);
        List<User> users =  userDao.getAll();
        addRequestPerformer.addAttribute("users", users);
        return "addRequestPerformer";
    }

    @RequestMapping(value = "/addRequestPerformer", method = RequestMethod.POST)
    public String  addRequestPerformer(@RequestParam("idrequest") String idrequest,
                                            @RequestParam("name") String name,
                                            @RequestParam("description") String description,
                                            @RequestParam("dateCreator") String dateCreator,
                                            @RequestParam("creator") String creator,
                                            @RequestParam("idrequesttypes") String idrequesttypes,
                                            @RequestParam("iduser") String iduser){
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

        User user = userDao.getById(Integer.parseInt(iduser));
        request.setAssignedTo(user);


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