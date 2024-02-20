package com.example.demo.services.impl;

import com.example.demo.domain.entities.T_People;
import com.example.demo.domain.models.AddressModel;
import com.example.demo.repository.AddressRepository;
import com.example.demo.services.AddressService;
import org.modelmapper.ModelMapper;

import java.util.List;

public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public AddressServiceImpl(AddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AddressModel> findAllByPerson(T_People people) {

        return findAllByPerson(people).stream().map(e -> modelMapper.map(e , AddressModel.class)).toList();
    }
}
