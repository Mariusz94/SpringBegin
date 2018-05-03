package pl.lyszczarzmariusz.SpringBegin.controllers;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String loginGet(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String loginPost(@RequestParam("login") String login,
                            @RequestParam("password") String password){
        if(login.equals("Mariusz") && password.equals("mariusz")){
            return "Zalogowno";
        }
        return "Błędne hasło";
    }

    @RequestMapping(value = "/register", method=RequestMethod.GET)
    public String registerGet(){
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String registerPost(@RequestParam("login") String login,
                            @RequestParam("password") String password,
                            @RequestParam("repeatPassword") String repeatPassword,
                            @RequestParam("email") String email,
                            Model model){
        if(!password.equals(repeatPassword)){
            model.addAttribute("errorPassword", true);
            return "register";
        }

        return "home";
    }
}
