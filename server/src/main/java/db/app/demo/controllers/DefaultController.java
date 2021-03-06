package db.app.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping
    public String defaultPage() {
        return "redirect:/students/";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
}
