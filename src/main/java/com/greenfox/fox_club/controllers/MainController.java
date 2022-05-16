package com.greenfox.fox_club.controllers;

import com.greenfox.fox_club.models.Fox;
import com.greenfox.fox_club.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    private FoxService foxService;

    @Autowired
    public MainController(FoxService foxService) {
        this.foxService = foxService;
    }

    @GetMapping("")
    public String showItems (Model model, @RequestParam("name")  String name){
        model.addAttribute("fox",foxService.getActiveFox(name));
        if (foxService.isMrGreen()) {
            model.addAttribute("isMrGreen",true);
        }
        return "index";
    }

    @GetMapping("/login")
    public String showLogin (Model model){
        return "login";
    }

    @PostMapping ("/login")
    public String sendName (RedirectAttributes attributes, @RequestParam("name") String name){
        if (foxService.getFoxes().isEmpty()) {
            foxService.addFox(name);
            return "redirect:/?name="+name;
        } else {
            if (foxService.checkFox(name)) {
                return "redirect:/?name="+name;
            } else {
                attributes.addFlashAttribute("noPet","No pet associated to this name!");
                return "redirect:/login";
            }
        }

    }

    @GetMapping("/nutritionStore")
    public String showStore (Model model, @RequestParam(value = "name")  String name){
        model.addAttribute("listOfFood",foxService.getFoodTypes());
        model.addAttribute("listOfDrink",foxService.getDrinkTypes());
        model.addAttribute("foxName", name);
        return "store";
    }

    @GetMapping("/trickCenter")
    public String showTrickCenter (Model model, @RequestParam(value = "name")  String name){
        model.addAttribute("listOfTricks",foxService.getListOfTricks());
        model.addAttribute("activeFox",foxService.getActiveFox(name));
        model.addAttribute("foxName", name);
        return "tricks";
    }


}
