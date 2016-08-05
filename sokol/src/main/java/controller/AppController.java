package controller;

import beans.impl.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("hello", messageService.getInfo());
        return "index";
    }
}
