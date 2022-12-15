package com.webapp.coffeesearch.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.webapp.coffeesearch.Entity.Fav;
import com.webapp.coffeesearch.Entity.Users;
import com.webapp.coffeesearch.Repository.UsersRepository;
import com.webapp.coffeesearch.Service.HomeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @Autowired
    UsersRepository usersRepository;

    // -----DISPLAY-----
    @GetMapping("/")
    public String displayHome(Model model, HttpSession session) throws JsonProcessingException {
        Long usersId = (Long) session.getAttribute(SessionConstants.APP_USERID);
        Optional<Users> users = usersId == null ? Optional.empty() : usersRepository.findById(usersId);
        if(users.isPresent()) {
            List<Fav> favList =  users.get().getFavList();
            model.addAttribute("users", users.get());
            model.addAttribute("favList",favList);
            return "home";
        } else {
            return "redirect:/login";
        }
    }
    
    // -----DELETE-----
    @GetMapping("/fav-delete")
    public String deleteFav(Model model, Fav fav) {
        homeService.delete(fav.getFavId());
        return "redirect:/home";
    }
    
}
