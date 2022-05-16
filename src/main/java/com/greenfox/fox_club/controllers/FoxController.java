package com.greenfox.fox_club.controllers;

import com.greenfox.fox_club.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FoxController {

    private FoxService foxService;

    @Autowired
    public FoxController(FoxService foxService) {
        this.foxService = foxService;
    }

    @PostMapping("/nutritionStore")
    public String showStore ( @RequestParam(value = "name")  String name, @RequestParam(value = "food")  String food, @RequestParam(value = "drink")  String drink){
        foxService.getActiveFox(name).setFood(food);
        foxService.getActiveFox(name).setDrink(drink);
        return "redirect:/?name="+name;
    }

    @PostMapping("/trickCenter")
    public String showTrickCenter (RedirectAttributes attributes, @RequestParam(value = "name")  String name, @RequestParam(value = "trick")  String trick){
        if (!foxService.checkTricks(name,trick)) {
            foxService.getActiveFox(name).getTricks().add(trick);
            return "redirect:/?name="+name;
        } else {
            attributes.addFlashAttribute("trickExist","The pet already knows this trick, please choose the new one");
            return "redirect:/trickCenter/?name="+name;
        }
    }


}
