package com.webapp.coffeesearch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.webapp.coffeesearch.Entity.Users;
import com.webapp.coffeesearch.Repository.AuthRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    AuthRepository authRepository;

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("users", new Users());
        return "auth/login";
    }
    
    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("users", new Users());
        return "auth/register";
    }

    @PostMapping("/login")
    public String handleLogin(Users users, Model model, HttpSession session) {
        System.out.println(users.getEmail());
        System.out.println(users.getPassword());
        Users searchResult = authRepository.findByEmailAndPassword(users.getEmail(), users.getPassword());
        if (searchResult != null) {
            // setAttribute:register data to be saved as "name"(1st parameter/String) and "value"(2nd parameter/Object) pairs
            session.setAttribute(SessionConstants.APP_USERID, Long.valueOf(searchResult.getUsersId()));
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/register")
    public String handleRegister(Users users, Model model) {
        if (users.getName() != null && users.getEmail() != null && users.getPassword() != null) {
            authRepository.save(users);
            return "redirect:/";
        } else {
            return "redirect:/register";
        }
    }
    
}
