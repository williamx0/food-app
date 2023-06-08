package com.mystartup.food.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mystartup.food.model.Food;
import com.mystartup.food.service.FoodService;


@Controller
public class FoodController {

    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/home")
    public String addFood(Model model, Food food) {


        if (food.getPrice() > 1000) {
            model.addAttribute("errorMessage", String.format("Could not add %s it is too expensive", food.getName()));         
        } else if (foodService.addFood(food) < 1) {
            model.addAttribute("errorMessage", String.format("Could not add %s", food.getName()));
        } else {
            model.addAttribute("successMessage", String.format("Successfully added %s", food.getName()));
        }
        

        Food[] foods = foodService.getFoods();
        model.addAttribute("foods", foods);
        return "home";
    } 
    
    @GetMapping("/home")
    public String getHome(Model model, Food food) {
        
        Food[] foods = foodService.getFoods();

        model.addAttribute("foods", foods);

        return "home";

    }

}
