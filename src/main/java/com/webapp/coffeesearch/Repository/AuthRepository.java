package com.webapp.coffeesearch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.coffeesearch.Entity.Users;

public interface AuthRepository extends JpaRepository<Users, Long>{

    Users findByEmailAndPassword(String email, String password);
    
}
