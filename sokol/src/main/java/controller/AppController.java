package controller;

import beans.impl.MessageService;
import beans.impl.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private User user;


    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("hello", messageService.getInfo());
        return "index";
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
