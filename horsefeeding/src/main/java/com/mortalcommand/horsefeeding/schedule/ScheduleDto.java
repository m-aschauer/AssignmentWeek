package com.mortalcommand.horsefeeding.schedule;

/**
 * Data Transfer Object (DTO) representing a feeding schedule.
 */
public class ScheduleDto {
    private Long id;
    private String feedingStart;
    private String feedingEnd;
    private String horseNickName;
    private String horseGuid;

    /**
     * Get the ID of the feeding schedule.
     *
     * @return The ID of the feeding schedule.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the feeding schedule.
     *
     * @param id The ID of the feeding schedule.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the start time of feeding in the schedule.
     *
     * @return The feeding start time.
     */
    public String getFeedingStart() {
        return feedingStart;
    }

    /**
     * Set the start time of feeding in the schedule.
     *
     * @param feedingStart The feeding start time.
     */
    public void setFeedingStart(String feedingStart) {
        this.feedingStart = feedingStart;
    }

    /**
     * Get the end time of feeding in the schedule.
     *
     * @return The feeding end time.
     */
    public String getFeedingEnd() {
        return feedingEnd;
    }

    /**
     * Set the end time of feeding in the schedule.
     *
     * @param feedingEnd The feeding end time.
     */
    public void setFeedingEnd(String feedingEnd) {
        this.feedingEnd = feedingEnd;
    }

    /**
     * Get the nickname of the horse associated with the schedule.
     *
     * @return The horse's nickname.
     */
    public String getHorseNickName() {
        return horseNickName;
    }

    /**
     * Set the nickname of the horse associated with the schedule.
     *
     * @param horseNickName The horse's nickname.
     */
    public void setHorseNickName(String horseNickName) {
        this.horseNickName = horseNickName;
    }

    /**
     * Get the GUID (Globally Unique Identifier) of the horse associated with the schedule.
     *
     * @return The horse's GUID.
     */
    public String getHorseGuid() {
        return horseGuid;
    }

    /**
     * Set the GUID (Globally Unique Identifier) of the horse associated with the schedule.
     *
     * @param horseGuid The horse's GUID.
     */
    public void setHorseGuid(String horseGuid) {
        this.horseGuid = horseGuid;
    }
}
