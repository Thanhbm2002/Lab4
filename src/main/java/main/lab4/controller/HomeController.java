package main.lab4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/index")
    public String index(Model model) {
        return "home/home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "home/about";
    }
}
