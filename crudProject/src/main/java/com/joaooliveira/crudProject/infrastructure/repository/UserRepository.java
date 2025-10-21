package com.joaooliveira.crudProject.infrastructure.repository;

import com.joaooliveira.crudProject.infrastructure.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    @Transactional
    void deleteById(Integer id);
}
