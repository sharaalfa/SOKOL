package io.khasang.sokol.controller;

import io.khasang.sokol.dao.RequestDao;
import io.khasang.sokol.dao.RequestTypeDao;
import io.khasang.sokol.dao.TempDao;
import io.khasang.sokol.entity.Request;
import io.khasang.sokol.entity.RequestType;
import io.khasang.sokol.entity.Temp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static io.khasang.sokol.entity.RequestStatus.Declined;
import static io.khasang.sokol.entity.RequestStatus.New;
import static io.khasang.sokol.entity.RequestStatus.Closed;

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

    @RequestMapping(value = "/addRequestCreator", method = RequestMethod.GET)
    public String addRequestCreatorPage(Model addRequestCreator){
        List<RequestType> requestTypes =  requestTypeDao.getAll();
        List listTitleRequestTypes = new ArrayList();
        for (RequestType requestType : requestTypes
             ) {listTitleRequestTypes.add(requestType.getTitle());
        }
        addRequestCreator.addAttribute("listTitleRequestTypes", listTitleRequestTypes);
        return "addRequestCreator";
    }

    @RequestMapping(value = "/addRequestCreator", method = RequestMethod.POST)
    public ModelAndView addRequestCreator(@RequestParam("name") String name,
                                          @RequestParam("description") String description,
                                          @RequestParam("typerequest") String typerequest) {
        ModelAndView model = new ModelAndView();
        Request request = new Request();
        request.setTitle(name);
        request.setDescription(description);
        request.setStatus(New);
        request.setVersion(1);
        request.setCreatedDate(new Date());
        RequestType requestType =  requestTypeDao.getByTitle(typerequest);
        request.setRequestType(requestType);
        requestDao.save(request);
        model.setViewName("addRequestCreator");
        return model;
    }

    // добавление запроса на редактирование
    @RequestMapping(value = "/addRequestPerformer", method = RequestMethod.GET)
    public String addRequestPerformerPage(Model addRequestPerformer, @RequestParam("idRequest") String idRequest){
        Request request =  requestDao.getByRequestId(Integer.parseInt(idRequest));
        addRequestPerformer.addAttribute("request", request);

        List<RequestType> requestTypes =  requestTypeDao.getAll();
        List listTitleRequestTypes = new ArrayList();
        for (RequestType requestType : requestTypes
                ) {listTitleRequestTypes.add(requestType.getTitle());
        }
        addRequestPerformer.addAttribute("listTitleRequestTypes", listTitleRequestTypes);

        return "addRequestPerformer";
    }

    @RequestMapping(value = "/addRequestPerformer", method = RequestMethod.POST)
    public ModelAndView addRequestPerformer(@RequestParam("idRequest") String idRequest,
                                            @RequestParam("name") String name,
                                            @RequestParam("description") String description,
                                            @RequestParam("dateCreator") String dateCreator,
                                            @RequestParam("typerequest") String typerequest) {
        ModelAndView model = new ModelAndView();
        Request request = requestDao.getByRequestId(Integer.parseInt(idRequest));
        request.setTitle(name);
        request.setDescription(description);
        request.setStatus(Declined);
        request.setUpdatedDate(new Date());
        RequestType requestType =  requestTypeDao.getByTitle(typerequest);
        request.setRequestType(requestType);
      //  request.setVersion(1);
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
        requestDao.update(request);
        model.setViewName("addRequestPerformer");
        return model;
    }
}
/*              Temp temp = tempDao.getById(Integer.parseInt(idRequest));
        temp.setName(description);
     //   temp.setCreatedBy("CreatedBy2");
        temp.setCreatedBy(dateCreator);
        temp.setUpdatedDate(new Date());
        tempDao.update(temp);*/