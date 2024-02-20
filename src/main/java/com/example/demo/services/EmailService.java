package com.example.demo.services;

import com.example.demo.domain.entities.T_People;
import com.example.demo.domain.models.MailModel;
import com.example.demo.domain.models.PeopleModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmailService {

    List<MailModel> findEmailsByPeople(T_People people);
}
