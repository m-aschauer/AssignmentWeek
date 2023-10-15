package com.mortalcommand.horsefeeding.horse;

/**
 * Represents data about a horse's feeding eligibility based on the time it has not eaten.
 */
public class EligibleHorseDto {
    private String amountTime; // Time duration since the horse last ate.
    private String horseGuid; // The unique identifier of the horse.

    /**
     * Get the time duration since the horse last ate.
     * @return The amount of time since the last feeding.
     */
    public String getAmountTime() {
        return amountTime;
    }

    /**
     * Set the time duration since the horse last ate.
     * @param amountTime The amount of time since the last feeding.
     */
    public void setAmountTime(String amountTime) {
        this.amountTime = amountTime;
    }

    /**
     * Get the unique identifier of the horse.
     * @return The unique identifier of the horse.
     */
    public String getHorseGuid() {
        return horseGuid;
    }

    /**
     * Set the unique identifier of the horse.
     * @param horseGuid The unique identifier of the horse.
     */
    public void setHorseGuid(String horseGuid) {
        this.horseGuid = horseGuid;
    }
}
