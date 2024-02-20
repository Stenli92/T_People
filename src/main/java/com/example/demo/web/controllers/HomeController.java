package com.example.demo.web.controllers;

import com.example.demo.domain.entities.T_People;
import com.example.demo.domain.models.PeopleModel;
import com.example.demo.repository.PeopleRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private final PeopleRepository repository;
    private final ModelMapper mapper;


    private final HttpServletRequest request;

    public HomeController(PeopleRepository repository, ModelMapper mapper, HttpServletRequest request) {
        this.repository = repository;
        this.mapper = mapper;
        this.request = request;
    }

    @GetMapping("/")
    public String  index(){
        return "/home/index";
    }

    @PostMapping("/")
    public String  handleSearch(@RequestParam String personName){


        if (personName.length() < 2){
            return "redirect:/";

        }else {
            if (this.repository.existsByFullnameContaining(personName)){
                HttpSession session = request.getSession(true);
                session.setAttribute("input" , personName);
                return "redirect:/people/show-people";

            }else {
                return "redirect:/";
            }
        }


    }

}
