package com.webapp.coffeesearch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.coffeesearch.Entity.Fav;

public interface FavRepository extends JpaRepository<Fav, Long> {
    
}
