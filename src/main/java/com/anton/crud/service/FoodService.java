package com.anton.crud.service;

import com.anton.crud.model.Food;
import com.anton.crud.repo.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;

//    create foods
    public Food createFoods(Food food){
        return foodRepository.save(food);
    }

//    get foods
    public List<Food> getFoods(){
        return foodRepository.findAll();
    }

//    get foods by id
    public Food getFoodByID(Long id) {
        return foodRepository.findById(id).get();
    }

//    update foods
    public Food updateFoods(Food food){
        return foodRepository.save(food);
    }

//    delete foods
    public void deleteFoods(Long id) {
        foodRepository.deleteById(id);
    }

}
