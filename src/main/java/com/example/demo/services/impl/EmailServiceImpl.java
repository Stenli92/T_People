package com.example.demo.services.impl;

import com.example.demo.domain.entities.T_Mails;
import com.example.demo.domain.entities.T_People;
import com.example.demo.domain.models.MailModel;
import com.example.demo.domain.models.PeopleModel;
import com.example.demo.repository.EmailRepository;
import com.example.demo.services.EmailService;
import org.modelmapper.ModelMapper;

import java.util.List;

public class EmailServiceImpl implements EmailService {

    private final ModelMapper modelMapper;
    private final EmailRepository emailRepository;

    public EmailServiceImpl(ModelMapper modelMapper, EmailRepository emailRepository) {
        this.modelMapper = modelMapper;
        this.emailRepository = emailRepository;
    }

    @Override
    public List<MailModel> findEmailsByPeople(T_People people) {

        return this.emailRepository.findAllByPeople(people).stream().map(e -> modelMapper.map(e , MailModel.class)).toList();
    }
}
