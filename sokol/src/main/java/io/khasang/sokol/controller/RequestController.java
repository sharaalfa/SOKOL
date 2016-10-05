package io.khasang.sokol.controller;

import io.khasang.sokol.dao.RequestDao;
import io.khasang.sokol.dao.RequestTypeDao;
import io.khasang.sokol.entity.Request;
import io.khasang.sokol.entity.RequestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static io.khasang.sokol.entity.RequestStatus.Closed;

/**
 * Created by Andrey on 02.10.2016.
 */
@Controller
public class RequestController {
    @Autowired
    RequestDao requestDao;

    @RequestMapping(value = "/listRequest", method = RequestMethod.GET)
    public String listRequestPage(Model listRequest){
        List<Request> listRequests =  requestDao.getAll();
        listRequest.addAttribute("listRequests", listRequests);
        return "listRequest";
    }

    @RequestMapping(value = "/listRequest", method = RequestMethod.POST)
    public String listRequest(Model model,  @RequestParam("name") String name){
        // requestDao.save(request);


        model.addAttribute("name", name);
        model.addAttribute("name", name);
        return "addRequestPerformer";
    }

    @RequestMapping(value = "/addRequestCreator", method = RequestMethod.GET)
    public String addRequestCreatorPage(Model addRequestCreator){
        addRequestCreator.addAttribute("addRequestCreator", addRequestCreator);
        return "addRequestCreator";
    }

/*    @RequestMapping(value = "/addRequestCreator", method = RequestMethod.POST)
    public String addRequestCreator(Model model,  @RequestParam("name") String name, @RequestParam("description") String description ){
        //Request request = new Request();
        //requestDao.save(request);
        model.addAttribute("name", name);
        model.addAttribute("description", description);
        return "hello";
    }*/

/*    @RequestMapping(value = "/addRequestCreator", method = RequestMethod.POST)
    public String addRequestCreator(Model model,  @RequestParam("name") String name, @RequestParam("description") String description ){
        //Request request = new Request();
        //requestDao.save(request);
        model.addAttribute("name", name);
        model.addAttribute("description", description);
        return "hello";
    }*/

    @RequestMapping(value = "/addRequestCreator", method = RequestMethod.POST)
    public ModelAndView addRequestCreator(Request request  ) {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Post registration form");
        request.setStatus(Closed);
        request.setTitle("title");
        RequestType requestType = RequestTypeDao.getByID(1);
        request.setRequestType(requestType);
        model.setViewName("addRequestCreator");
        requestDao.save(request);
        return model;
    }






    @RequestMapping(value = "/addRequestPerformer", method = RequestMethod.GET)
    public String addRequestPerformerPage(Model addRequestPerformer, @RequestParam("idRequest") String idRequest){
        // public String addRequestPerformerPage(Model addRequestPerformer){
        Request request =  requestDao.getByRequestId(Integer.parseInt(idRequest));
        addRequestPerformer.addAttribute("request", request);
     /*   addRequestPerformer.addAttribute("idRequest", idRequest);*/
        return "addRequestPerformer";
    }

    /*    @RequestMapping(value = "/addRequestPerformer", method = RequestMethod.POST)
    public String addRequestPerformer(Model model,  @RequestParam("name") String name, @RequestParam("description") String description ){
        // requestDao.save(request);
        model.addAttribute("name", name);
        model.addAttribute("description", description);
        return "hello";
    }*/

    @RequestMapping(value = "/addRequest", method = RequestMethod.GET)
    public String addRequestPage(Model addRequest){
        addRequest.addAttribute("addRequest", addRequest);
        return "addRequest";
    }

    @RequestMapping(value = "/addRequest", method = RequestMethod.POST)
    public String addRequest(Model model,  @RequestParam("name") String name, @RequestParam("performer") String performer ){
        // requestDao.save(request);
        model.addAttribute("name", name);
        model.addAttribute("performer", performer);

        return "hello";
    }
}
