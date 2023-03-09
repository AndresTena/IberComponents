package es.code.urjc.ibercomponents.controllers;

import es.code.urjc.ibercomponents.entities.User;
import es.code.urjc.ibercomponents.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String login(Model model) {


        return "login";
    }

    @GetMapping("/signin")
    public String signin(Model model) {

        return "sign-in";
    }

    @PostMapping("/signin")
    public String signInProcess(Model model, User user) throws IOException
    {
        if(user.getName() != null && user.getGmail() != null && user.getPassword() != null) {
            userService.save(user);

            //model.addAttribute("User", user);
        }

        return "redirect:/";

    }

    @GetMapping("/loginError")
    public String loginError(Model model)
    {
        return "loginError";
    }
}
