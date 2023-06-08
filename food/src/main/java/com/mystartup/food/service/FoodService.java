package com.mystartup.food.service;

import org.springframework.stereotype.Service;
import com.mystartup.food.model.Food;

import com.mystartup.food.mapper.FoodMapper;

@Service
public class FoodService {

    private FoodMapper foodMapper;

    public FoodService(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    public int addFood(Food food) {
        return foodMapper.insertFood(food);
    }
    
    public Food[] getFoods() {

        Food[] foods = foodMapper.selectFoods();
        return foods;
    } 
}
