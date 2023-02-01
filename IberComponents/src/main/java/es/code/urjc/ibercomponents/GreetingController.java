package es.code.urjc.ibercomponents;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/home")
    public String home(Model model) {

        model.addAttribute("name", "Mundo");

        return "index";
    }


    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("name", "Mundo");

        return "login";
    }

    @GetMapping("/signin")
    public String signin(Model model) {

        model.addAttribute("name", "Mundo");

        return "sign-in";
    }



}