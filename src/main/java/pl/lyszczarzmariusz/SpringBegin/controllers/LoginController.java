package pl.lyszczarzmariusz.SpringBegin.controllers;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.lyszczarzmariusz.SpringBegin.models.RegisterForm;

import javax.validation.Valid;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String loginPost(@RequestParam("login") String login,
                            @RequestParam("password") String password) {
        if (login.equals("Mariusz") && password.equals("mariusz")) {
            return "Zalogowno";
        }
        return "Błędne dane";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerGet(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(@Valid @ModelAttribute("registerForm") RegisterForm registerForm,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()){
            return "register";
        }

        if (!registerForm.getPassword().equals(registerForm.getRepeatPassword())) {
            model.addAttribute("errorPassword", true);
            return "register";
        }

        return "home";
    }
}
