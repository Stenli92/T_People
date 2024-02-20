package com.example.demo.repository;

import com.example.demo.domain.entities.T_People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<T_People , Long> {
    Optional<List<T_People>> findByFullNameContaining(String name);

    @Query("SELECT COUNT(p) > 0 FROM T_People p WHERE p.fullName LIKE %:input%")
    boolean existsByFullnameContaining( String input);

    Optional<T_People> findById(Long id);
    void deleteById(Long id);
}
