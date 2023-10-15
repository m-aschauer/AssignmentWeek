package com.mortalcommand.horsefeeding.event;

/**
 * Data Transfer Object (DTO) for representing horse feeding events.
 */
public class EventDto {

    private Long id;
    private String feedingTime;
    private String status;
    private String horseGuid;
    private String horseName;
    private String foodType;

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
     * Get the unique identifier (GUID) of the horse associated with the event.
     *
     * @return The horse's unique identifier (GUID).
     */
    public String getHorseGuid() {
        return horseGuid;
    }

    /**
     * Set the unique identifier (GUID) of the horse associated with the event.
     *
     * @param horseGuid The horse's unique identifier (GUID) to set.
     */
    public void setHorseGuid(String horseGuid) {
        this.horseGuid = horseGuid;
    }

    /**
     * Get the name of the horse associated with the event.
     *
     * @return The name of the horse.
     */
    public String getHorseName() {
        return horseName;
    }

    /**
     * Set the name of the horse associated with the event.
     *
     * @param horseName The name of the horse to set.
     */
    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    /**
     * Get the type of food provided during the feeding event.
     *
     * @return The type of food.
     */
    public String getFoodType() {
        return foodType;
    }

    /**
     * Set the type of food provided during the feeding event.
     *
     * @param foodType The type of food to set.
     */
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
}
