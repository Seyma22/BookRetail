package controller;

import model.Book;
import model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.impl.RoleService;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    //Get all roles
    @RequestMapping(value="/roles" ,method= RequestMethod.GET)
    public String findAll(Model model){
        model.addAttribute("role", new Role());
        return "index";
    }

    //Register a new role
    @RequestMapping(value="/roles/id" ,method= RequestMethod.POST)
    public String saveRole(@ModelAttribute("role") Role role, BindingResult result, Model model){
        model.addAttribute("role", role);

        if (result.hasErrors()){
            return "register";
        } else {
            roleService.saveRole(role);
        }
        return "index";
    }

    //Delete a role
    @RequestMapping(value="/roles/id" , method= RequestMethod.DELETE)
    public void deleteRole(Role role){
        roleService.deleteRole(role);
    }


}
