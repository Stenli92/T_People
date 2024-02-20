package com.example.demo.services;

import com.example.demo.domain.models.PeopleModel;
import com.example.demo.web.models.PeopleServiceModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PeopleService {

    List<PeopleModel> findAllPeople(String input);
    void removePeople(String id);

    void createPeople(PeopleServiceModel model);

    PeopleModel findPersonById(String id);

    void updatePeople(PeopleServiceModel peopleServiceModel , String id);
}
