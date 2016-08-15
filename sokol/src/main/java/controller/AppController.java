package controller;

import beans.IMessageService;
import beans.impl.HelloMessage;
import beans.impl.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    @Autowired
    private IMessageService messageService;

    @Autowired
    private User user;


    @RequestMapping("/index")
    public String hello(Model model){
        model.addAttribute("hello", messageService.getInfo());
        return "index";
    }

    @RequestMapping("/admin/test")
    public String hello2(Model model){
        return "test";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout){
        ModelAndView model = new ModelAndView();
        model.setViewName("login");

        return model;
    }



    @RequestMapping("/first")
    public String firstPage(Model model){
        model.addAttribute("user", user);
        return "first";
    }

    @RequestMapping("/second")
    public String secondPage(Model model, @ModelAttribute User modelUser){
        model.addAttribute("user", modelUser);
        return "second";
    }
}
