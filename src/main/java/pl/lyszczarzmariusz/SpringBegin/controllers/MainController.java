package pl.lyszczarzmariusz.SpringBegin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "check/{age}/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String check(@PathVariable("age") int age,
                        @PathVariable("name") String name){
        return age >= 18 ? "witaj " + name : "papa";
    }

    @RequestMapping(value = "zipcheck/{zip}", method = RequestMethod.GET)
    public String zipCheck(@PathVariable("zip") String zip,
                        Model model){
        String pattern = "[0-9]{2}-[0-9]{3}";

        model.addAttribute("isValid",Pattern.matches(pattern, zip));

        return "zipcode";
    }
}
