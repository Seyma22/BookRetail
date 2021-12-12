package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.impl.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    //Get
    @RequestMapping(value="/users" ,method= RequestMethod.GET)
    public String findAll(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    //Register a new customer
    @RequestMapping(value="/user/id" ,method= RequestMethod.POST)
    public String saveUser( @ModelAttribute("user") User user, BindingResult result, Model model){
        model.addAttribute("user", user);

        if (result.hasErrors()){
            return "register";
        } else {
            userService.saveUser(user);

        }
        return "index";
    }

    //Delete an user
    @RequestMapping(value="/users/id" , method= RequestMethod.DELETE)
    public void deleteUser(User user){
        userService.deleteUser(user);
    }

    @RequestMapping(value="/users/id", method= RequestMethod.PUT)
    public User updateUser(User user){
        userService.saveUser(user);
        return user;
    }

    //thymeleaf page refirects
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){ return "register";
    }
    @RequestMapping("/secure")
    public String secure(){ return "secure";
    }
}