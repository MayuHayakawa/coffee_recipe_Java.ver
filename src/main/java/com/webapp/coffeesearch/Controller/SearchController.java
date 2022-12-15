package com.webapp.coffeesearch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.webapp.coffeesearch.Entity.Fav;
import com.webapp.coffeesearch.Repository.FavRepository;
import com.webapp.coffeesearch.Repository.UsersRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    FavRepository favRepository;

    @GetMapping("/")
    public String displaySearch() {
        return "search";
    }
    
    @PostMapping("/save")
    public String saveFav(Fav fav, HttpSession session) {
        Long usersId = (Long) session.getAttribute(SessionConstants.APP_USERID);
        fav.setUsers(usersRepository.getReferenceById(usersId));
        favRepository.save(fav);
        return "redirect:/search/";
    }
}
