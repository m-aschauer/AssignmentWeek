package com.mortalcommand.horsefeeding.food;

import jakarta.persistence.*;

/**
 * Entity class representing food items for horses.
 */
@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private double quantity;

    /**
     * Get the unique identifier of the food item.
     *
     * @return The unique identifier (ID) of the food item.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of the food item.
     *
     * @param id The unique identifier (ID) to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

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
