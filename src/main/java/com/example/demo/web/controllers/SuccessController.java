package com.example.demo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/success")
public class SuccessController {

    @GetMapping("/update")
    public String index(){
        return "success/success-update";
    }

    @GetMapping("/delete")
    public String delete(){
        return "success/delete";
    }
}
