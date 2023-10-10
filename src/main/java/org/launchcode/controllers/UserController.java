package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, String verify, Errors errors) {
        if(errors.hasErrors()){

            return "user/add";
        }else {

            model.addAttribute("user", user);
//            model.addAttribute("username", user.getUsername());
//            model.addAttribute("email", user.getEmail());
//            model.addAttribute("username", user.getPassword());
            model.addAttribute("verify", verify);
            //model.addAttribute(new User());

            if (user.getPassword().equals(verify)) {
                return "user/index";
            } else {
                model.addAttribute("error", "Invalid: Passwords do not match");
                model.addAttribute("username", user.getUsername());
                model.addAttribute("email", user.getEmail());
                model.addAttribute(new User());
                return "user/add";

            }

        }
    }


}
