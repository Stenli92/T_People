package com.example.demo.repository;

import com.example.demo.domain.entities.T_Addresses;
import com.example.demo.domain.entities.T_People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<T_Addresses , Long> {

    List<T_Addresses> findT_AddressesByPeople(T_People people);
}
