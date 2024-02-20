package com.example.demo.web.controllers;

import com.example.demo.domain.models.PeopleModel;
import com.example.demo.services.PeopleService;
import com.example.demo.web.models.PeopleServiceModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;
    private final HttpServletRequest request;

    public PeopleController(PeopleService peopleService, HttpServletRequest request) {
        this.peopleService = peopleService;
        this.request = request;
    }

    @ModelAttribute("peopleServiceModel")
    public PeopleServiceModel registerModel(){

        return new PeopleServiceModel();
    }

    @GetMapping("/show-people")
    public String index(Model model){
        HttpSession session = request.getSession();

        List<PeopleModel> peopleList = peopleService.findAllPeople(session.getAttribute("input").toString());

        if (peopleList.size() != 0){
            model.addAttribute("peopleList" , peopleList );
        }else {
            return "redirect:/";
        }

        return "people/index.html";
    }

    @GetMapping("/add-people")
    public String addPeople( Model model){

        model.addAttribute("peopleServiceModel" , new PeopleServiceModel());
        return "people/add-people.html";
    }

    @PostMapping("/add-people")
    public String addPeople(@Valid @ModelAttribute("peopleServiceModel") PeopleServiceModel model  , BindingResult result){

        System.out.println(model);
        if (result.hasErrors()){
            return "/people/add-people";
        }
        this.peopleService.createPeople(model);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String removePeople(@PathVariable("id") String id){
        peopleService.removePeople(id);

        return "redirect:/success/delete";
    }

    @GetMapping("/edit/{id}")
    public String editPeople(@PathVariable("id") String id, Model model){
        PeopleModel personById = this.peopleService.findPersonById(id);

        model.addAttribute("peopleModel" , personById);

        HttpSession session = this.request.getSession();

        session.setAttribute("currentId" , id);

        return "people/edit-person.html";
    }

    @PostMapping("/edit/{id}")
    public String editPeople(@PathVariable String id, @Valid @ModelAttribute("peopleServiceModel") PeopleServiceModel peopleServiceModel , BindingResult result , Model model){

        if (result.hasErrors()){
            PeopleModel personById = this.peopleService.findPersonById(id);
            model.addAttribute("peopleModel" , personById);
            return "people/edit-person.html";
        }
        HttpSession session = this.request.getSession();

        String currentId = session.getAttribute("currentId").toString();

        peopleService.updatePeople(peopleServiceModel , currentId);
        return "redirect:/success/update";
    }
}
