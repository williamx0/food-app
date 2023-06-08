package com.mystartup.food.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mystartup.food.model.Food;


@Mapper
public interface FoodMapper {

   
    @Select("SELECT * FROM FOOD")
    Food[] selectFoods();

    @Insert("INSERT INTO FOOD (name, price) VALUES(#{name}, #{price})")
    int insertFood(Food food);
    
} 
