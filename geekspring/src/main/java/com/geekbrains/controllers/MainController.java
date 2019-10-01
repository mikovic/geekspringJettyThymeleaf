package com.geekbrains.controllers;

import com.geekbrains.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

@Controller
public class MainController {
    // https://getbootstrap.com/docs/4.1/getting-started/introduction/

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }    
}
