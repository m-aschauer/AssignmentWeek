package com.mortalcommand.horsefeeding.food;

import org.mapstruct.Mapper;

import java.util.List;

/**
 * A mapper interface for converting between Food and FoodDto objects.
 */
@Mapper(componentModel = "spring")
public interface FoodMapper {

    /**
     * Convert a list of Food objects to a list of FoodDto objects.
     *
     * @param foods The list of Food objects to convert.
     * @return A list of FoodDto objects.
     */
    List<FoodDto> foodsToFoodDto(List<Food> foods);

    /**
     * Convert a Food object to a FoodDto object.
     *
     * @param food The Food object to convert.
     * @return The corresponding FoodDto object.
     */
    FoodDto foodToFoodDto(Food food);

    /**
     * Convert a FoodDto object to a Food object.
     *
     * @param foodDto The FoodDto object to convert.
     * @return The corresponding Food object.
     */
    Food foodDtoToFood(FoodDto foodDto);
}
