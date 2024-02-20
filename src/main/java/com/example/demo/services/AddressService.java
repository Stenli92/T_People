package com.example.demo.services;

import com.example.demo.domain.entities.T_People;
import com.example.demo.domain.models.AddressModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    List<AddressModel> findAllByPerson(T_People people);
}
