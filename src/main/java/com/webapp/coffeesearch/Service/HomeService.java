package com.webapp.coffeesearch.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.coffeesearch.Repository.FavRepository;

@Service
public class HomeService {

    @Autowired
    FavRepository favRepository;

    // delete recipe from fav
    public void delete(Long favId) {
        favRepository.deleteById(favId);
    }
    
    
}
