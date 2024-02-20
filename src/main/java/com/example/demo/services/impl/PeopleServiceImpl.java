package com.example.demo.services.impl;

import com.example.demo.domain.entities.T_Addresses;
import com.example.demo.domain.entities.T_Mails;
import com.example.demo.domain.entities.T_People;
import com.example.demo.domain.models.AddressModel;
import com.example.demo.domain.models.MailModel;
import com.example.demo.domain.models.PeopleModel;
import com.example.demo.repository.PeopleRepository;
import com.example.demo.services.AddressService;
import com.example.demo.services.EmailService;
import com.example.demo.services.PeopleService;
import com.example.demo.web.models.PeopleServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleServiceImpl implements PeopleService {


    private final PeopleRepository peopleRepository;
    private final ModelMapper modelMapper;

    public PeopleServiceImpl(PeopleRepository peopleRepository, ModelMapper modelMapper) {
        this.peopleRepository = peopleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PeopleModel> findAllPeople(String input) {

        List<PeopleModel> peopleToShow = new ArrayList<>();

        Optional<List<T_People>> byFullNameContaining = Optional.ofNullable(this.peopleRepository.findByFullNameContaining(input).orElse(null));

        for (T_People tPeople : byFullNameContaining.get()) {
            PeopleModel model = new PeopleModel();

            model.setId(String.valueOf(tPeople.getId()));
            model.setFullName(tPeople.getFullName());
            model.setPin(tPeople.getPin());
            model.setMail(tPeople.getMails().get(0).getEMAIL());
            model.setMailType(tPeople.getMails().get(0).getEMAIL_TYPE());
            model.setAddrInfo(tPeople.getAddresses().get(0).getAddrInfo());
            model.setAddrType(tPeople.getAddresses().get(0).getAddrType());

            peopleToShow.add(model);

        }
        return peopleToShow;
    }

    @Override
    public void removePeople(String id) {

        this.peopleRepository.delete(this.peopleRepository.getById(Long.valueOf(id)));
    }

    @Override
    public void createPeople(PeopleServiceModel model) {

        T_People person = this.modelMapper.map(model, T_People.class);


        List<T_Addresses> addressesList = new ArrayList<>();
        List<T_Mails> mailsList = new ArrayList<>();
        T_Addresses address = new T_Addresses(model.getAddressType() , model.getAddressInfo());
        T_Mails mails = new T_Mails(model.getEmailType() , model.getEmail());

        address.setPeople(person);
        addressesList.add(address);
        mails.setPeople(person);
        mailsList.add(mails);

        person.setAddresses(addressesList);
        person.setMails(mailsList);



        this.peopleRepository.saveAndFlush(person);

    }

    @Override
    public PeopleModel findPersonById(String id) {


        Optional<T_People> peoplebyId = Optional.ofNullable(this.peopleRepository.findById(Long.valueOf(id)).orElse(null));

        PeopleModel model = new PeopleModel();

            if(peoplebyId != null){
                model.setFullName(peoplebyId.get().getFullName());
                model.setId(String.valueOf(peoplebyId.get().getId()));
                model.setPin(peoplebyId.get().getPin());
                model.setMail(peoplebyId.get().getMails().get(0).getEMAIL());
                model.setMailType(peoplebyId.get().getMails().get(0).getEMAIL_TYPE());
                model.setAddrInfo(peoplebyId.get().getAddresses().get(0).getAddrInfo());
                model.setAddrType(peoplebyId.get().getAddresses().get(0).getAddrType());
            }




        return model;
    }

    @Override
    public void updatePeople(PeopleServiceModel peopleServiceModel, String id) {

        Optional<T_People> peopleToUpdate = this.peopleRepository.findById(Long.valueOf(id));

        T_People updated = updateFromDB(peopleToUpdate.get(), peopleServiceModel);

        this.peopleRepository.save(updated);

    }

    private T_People updateFromDB(T_People entity , PeopleServiceModel peopleServiceModel){

        if(isToUpdate(entity.getFullName() ,peopleServiceModel.getFullName())){
            entity.setFullName(peopleServiceModel.getFullName());
        }
        if(isToUpdate(entity.getPin() ,peopleServiceModel.getPin())){
            entity.setPin(peopleServiceModel.getPin());
        }
        if(isToUpdate(entity.getMails().get(0).getEMAIL() ,peopleServiceModel.getEmail())){
            entity.getMails().get(0).setEMAIL(peopleServiceModel.getEmail());
        }
        if(isToUpdate(entity.getMails().get(0).getEMAIL_TYPE() , (peopleServiceModel.getEmailType()))){
            entity.getMails().get(0).setEMAIL_TYPE(peopleServiceModel.getEmailType());
        }
        if(isToUpdate(entity.getAddresses().get(0).getAddrType() , (peopleServiceModel.getAddressType()))){
            entity.getAddresses().get(0).setAddrType(peopleServiceModel.getAddressType());
        }
        if(isToUpdate(entity.getAddresses().get(0).getAddrInfo() , (peopleServiceModel.getAddressInfo()))){
            entity.getAddresses().get(0).setAddrInfo(peopleServiceModel.getAddressInfo());
        }


        return entity;
    }

    private boolean isToUpdate(String entityValue , String modelValue){

        if(!(modelValue == null || modelValue.isEmpty())){

            return !entityValue.equals(modelValue);

        }
        return false;
    }
}
