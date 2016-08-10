package controller;

import beans.IMessageService;
import beans.impl.HelloMessage;
import beans.impl.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/index2")
    public String hello2(Model model){
        model.addAttribute("hello", messageService.getInfo());
        return "index2";
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
