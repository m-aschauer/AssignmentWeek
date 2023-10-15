package com.mortalcommand.horsefeeding.food;

import com.mortalcommand.horsefeeding.food.FoodDto;
import com.mortalcommand.horsefeeding.food.Food;
import com.mortalcommand.horsefeeding.food.FoodMapper;
import com.mortalcommand.horsefeeding.food.FoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller class for managing food-related operations.
 */
@RestController
@RequestMapping("api/v1/foods")
public class FoodController {

    private final FoodService foodService;
    private final FoodMapper foodMapper;

    /**
     * Creates a new instance of FoodController.
     *
     * @param foodService The service for managing food types.
     * @param foodMapper The mapper for converting between Food and FoodDto objects.
     */
    public FoodController(FoodService foodService, FoodMapper foodMapper) {
        this.foodService = foodService;
        this.foodMapper = foodMapper;
    }

    /**
     * Get a list of all available food types.
     *
     * @return A ResponseEntity containing a list of FoodDto representing all food types.
     */
    @GetMapping("")
    public ResponseEntity<List<FoodDto>> showAllFoodTypes() {
        return ResponseEntity.ok(foodMapper.foodsToFoodDto(foodService.findAllFoodTypes()));
    }

    /**
     * Add a new food type.
     *
     * @param foodDto The FoodDto representing the new food type to be added.
     * @return A ResponseEntity containing the added FoodDto.
     */
    @PostMapping("")
    public ResponseEntity<FoodDto> addNewFoodType(@RequestBody FoodDto foodDto) {
        Food food = foodMapper.foodDtoToFood(foodDto);
        foodService.addNewFoodType(food);

        return ResponseEntity.ok(foodMapper.foodToFoodDto(food));
    }

    /**
     * Get information about a specific food type by its ID.
     *
     * @param id The identifier of the food type to retrieve.
     * @return A ResponseEntity containing the FoodDto of the specified food type, or a not found response.
     */
    @GetMapping("/{foodId}")
    public ResponseEntity showFoodType(@PathVariable("foodId") Long id) {
        Optional<Food> foodOptional = foodService.findFoodTypeById(id);
        if (foodOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foodMapper.foodToFoodDto(foodOptional.get()));
        }
    }

    /**
     * Delete a food type by its ID.
     *
     * @param id The identifier of the food type to delete.
     * @return A ResponseEntity indicating success or a not found response if the food type does not exist.
     */
    @DeleteMapping("/{foodId}")
    public ResponseEntity<FoodDto> deleteFoodType(@PathVariable("foodId") Long id) {
        Optional<Food> foodTypeToDelete = foodService.findFoodTypeById(id);
        if (foodTypeToDelete.isPresent()) {
            foodService.deleteFoodTypeById(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
