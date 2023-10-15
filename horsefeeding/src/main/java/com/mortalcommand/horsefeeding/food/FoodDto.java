package com.mortalcommand.horsefeeding.food;

/**
 * Data Transfer Object (DTO) for representing food items.
 */
public class FoodDto {

    private String name;
    private double quantity;

    /**
     * Get the name of the food item.
     *
     * @return The name of the food item.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the food item.
     *
     * @param name The name to set for the food item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the quantity of the food item.
     *
     * @return The quantity of the food item.
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the food item.
     *
     * @param quantity The quantity to set for the food item.
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
