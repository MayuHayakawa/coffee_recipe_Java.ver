package com.webapp.coffeesearch.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.coffeesearch.Entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

    @Override
    public List<Users> findAll();
    
}
