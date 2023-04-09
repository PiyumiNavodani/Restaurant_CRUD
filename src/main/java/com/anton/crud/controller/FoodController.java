package com.anton.crud.controller;

import com.anton.crud.model.Food;
import com.anton.crud.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodController {

    @Autowired
    FoodService foodService;

//    add foods
    @PostMapping(path = "/addFoods")
    public Food createFoods(@RequestBody Food food){
        return foodService.createFoods(food);
    }

//    get foods
    @GetMapping(path = "/getFoods")
    public List<Food> getFoods(){
        return foodService.getFoods();
    }

//    get foods by id
    @GetMapping("/deleteFoods/{id}")
    public void getFoodsById(@PathVariable Long id) {
        foodService.getFoodByID(id);
    }

//    update foods
    @PutMapping("/updateFoods/{id}")
    public ResponseEntity<?> updateFoods(@RequestBody Food food, @PathVariable Long id) {
        Optional<Food> findFood = Optional.ofNullable(foodService.getFoodByID(id));

            if(findFood.isPresent()){
                Food updateFood = findFood.get();
                updateFood.setFoodName(food.getFoodName());
                updateFood.setPrice(food.getPrice());
                updateFood.setDescription(food.getDescription());
                return new ResponseEntity<>(foodService.updateFoods(updateFood), HttpStatus.OK);

            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

//    delete foods
    @DeleteMapping("/deleteFoods/{id}")
    public void deleteFoods(@PathVariable Long id) {
        foodService.deleteFoods(id);
    }
}
