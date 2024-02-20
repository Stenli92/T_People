package com.example.demo.repository;

import com.example.demo.domain.entities.T_Mails;
import com.example.demo.domain.entities.T_People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<T_Mails , Long> {
    List<T_Mails> findAllByPeople(T_People people);
}
