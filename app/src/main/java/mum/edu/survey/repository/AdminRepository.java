package com.hellokoding.springboot.repository;

import com.hellokoding.springboot.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByUserName(String username);
}
