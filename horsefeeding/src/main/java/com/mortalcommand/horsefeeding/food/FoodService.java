package com.mortalcommand.horsefeeding.food;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing food-related operations.
 */
@Service
public class FoodService {

    private FoodRepository foodRepository;
    private FoodMapper foodMapper;

    /**
     * Creates a new instance of FoodService.
     *
     * @param foodRepository The repository for managing food types.
     * @param foodMapper The mapper for converting between Food and FoodDto objects.
     */
    public FoodService(FoodRepository foodRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    /**
     * Get a list of all available food types.
     *
     * @return A list of Food objects representing all food types.
     */
    public List<Food> findAllFoodTypes() {
        return foodRepository.findAll();
    }

    /**
     * Find a food type by its identifier.
     *
     * @param id The identifier of the food type to find.
     * @return An Optional containing the found Food, if it exists.
     */
    public Optional<Food> findFoodTypeById(Long id) {
        return foodRepository.findById(id);
    }

    /**
     * Find a food type by its name.
     *
     * @param name The name of the food type to find.
     * @return An Optional containing the found Food, if it exists.
     */
    public Optional<Food> findFoodTypeByName(String name) {
        return foodRepository.findByName(name);
    }

    /**
     * Add a new food type.
     *
     * @param food The Food to be added.
     * @return The added Food.
     */
    public Food addNewFoodType(Food food) {
        return foodRepository.save(food);
    }

    /**
     * Delete a food type by its identifier.
     *
     * @param id The identifier of the food type to delete.
     */
    public void deleteFoodTypeById(Long id) {
        foodRepository.deleteById(id);
    }
}
