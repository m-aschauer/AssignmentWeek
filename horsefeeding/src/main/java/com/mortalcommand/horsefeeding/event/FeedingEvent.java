package com.mortalcommand.horsefeeding.event;

import com.mortalcommand.horsefeeding.food.Food;
import com.mortalcommand.horsefeeding.horse.Horse;
import jakarta.persistence.*;

/**
 * Entity class representing a feeding event.
 */
@Entity
@Table(name = "feedingevent")
public class FeedingEvent {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;
    @Column(name = "time")
    private String feedingTime;
    @ManyToOne
    @JoinColumn(name = "guid")
    private Horse horse;
    @ManyToOne
    @JoinColumn(name = "food")
    private Food foodType;

    /**
     * Get the unique identifier of the feeding event.
     *
     * @return The unique identifier (ID) of the feeding event.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of the feeding event.
     *
     * @param id The unique identifier (ID) to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the status of the feeding event.
     *
     * @return The status of the feeding event.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status of the feeding event.
     *
     * @param status The status to set for the feeding event.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the time at which the feeding event occurred.
     *
     * @return The time of the feeding event.
     */
    public String getFeedingTime() {
        return feedingTime;
    }

    /**
     * Set the time at which the feeding event occurred.
     *
     * @param feedingTime The time to set for the feeding event.
     */
    public void setFeedingTime(String feedingTime) {
        this.feedingTime = feedingTime;
    }

    /**
     * Get the horse associated with the feeding event.
     *
     * @return The Horse object associated with the event.
     */
    public Horse getHorse() {
        return horse;
    }

    /**
     * Set the horse associated with the feeding event.
     *
     * @param horse The Horse object to associate with the event.
     */
    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    /**
     * Get the type of food provided during the feeding event.
     *
     * @return The Food object representing the type of food.
     */
    public Food getFoodType() {
        return foodType;
    }

    /**
     * Set the type of food provided during the feeding event.
     *
     * @param foodType The Food object representing the type of food to set.
     */
    public void setFoodType(Food foodType) {
        this.foodType = foodType;
    }
}
