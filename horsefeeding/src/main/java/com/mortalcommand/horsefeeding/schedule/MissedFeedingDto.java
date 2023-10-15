package com.mortalcommand.horsefeeding.schedule;

/**
 * Data Transfer Object (DTO) representing missed feedings for a horse.
 * It contains information about the horse, the number of feedings missed, and the total number of feedings.
 */
public class MissedFeedingDto {
    private String horseGuid;
    private String horseName;
    private int amountMissed;

    private int amountFood;

    /**
     * Get the GUID of the horse associated with the missed feedings.
     *
     * @return The GUID of the horse.
     */
    public String getHorseGuid() {
        return horseGuid;
    }

    /**
     * Set the GUID of the horse associated with the missed feedings.
     *
     * @param horseGuid The GUID of the horse to set.
     */
    public void setHorseGuid(String horseGuid) {
        this.horseGuid = horseGuid;
    }

    /**
     * Get the name of the horse associated with the missed feedings.
     *
     * @return The name of the horse.
     */
    public String getHorseName() {
        return horseName;
    }

    /**
     * Set the name of the horse associated with the missed feedings.
     *
     * @param horseName The name of the horse to set.
     */
    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    /**
     * Get the number of feedings missed for the horse.
     *
     * @return The number of feedings missed.
     */
    public int getAmountMissed() {
        return amountMissed;
    }

    /**
     * Set the number of feedings missed for the horse.
     *
     * @param amountMissed The number of feedings missed to set.
     */
    public void setAmountMissed(int amountMissed) {
        this.amountMissed = amountMissed;
    }

    /**
     * Get the total number of feedings for the horse.
     *
     * @return The total number of feedings.
     */
    public int getAmountFood() {
        return amountFood;
    }

    /**
     * Set the total number of feedings for the horse.
     *
     * @param amountFood The total number of feedings to set.
     */
    public void setAmountFood(int amountFood) {
        this.amountFood = amountFood;
    }
}
