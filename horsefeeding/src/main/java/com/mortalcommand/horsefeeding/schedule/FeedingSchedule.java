package com.mortalcommand.horsefeeding.schedule;

import com.mortalcommand.horsefeeding.horse.Horse;
import jakarta.persistence.*;

/**
 * Entity class representing a feeding schedule.
 */
@Entity
@Table(name = "feedingschedule")
public class FeedingSchedule {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start")
    private String feedingStart;

    @Column(name = "end")
    private String feedingEnd;

    @ManyToOne
    @JoinColumn(name = "guid")
    private Horse horse;

    /**
     * Get the unique identifier of the feeding schedule.
     *
     * @return The unique identifier (ID) of the feeding schedule.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of the feeding schedule.
     *
     * @param id The unique identifier (ID) to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the start time of the feeding schedule.
     *
     * @return The start time of the feeding schedule.
     */
    public String getFeedingStart() {
        return feedingStart;
    }

    /**
     * Set the start time of the feeding schedule.
     *
     * @param feedingStart The start time to set for the feeding schedule.
     */
    public void setFeedingStart(String feedingStart) {
        this.feedingStart = feedingStart;
    }

    /**
     * Get the end time of the feeding schedule.
     *
     * @return The end time of the feeding schedule.
     */
    public String getFeedingEnd() {
        return feedingEnd;
    }

    /**
     * Set the end time of the feeding schedule.
     *
     * @param feedingEnd The end time to set for the feeding schedule.
     */
    public void setFeedingEnd(String feedingEnd) {
        this.feedingEnd = feedingEnd;
    }

    /**
     * Get the horse associated with the feeding schedule.
     *
     * @return The Horse object associated with the feeding schedule.
     */
    public Horse getHorse() {
        return horse;
    }

    /**
     * Set the horse associated with the feeding schedule.
     *
     * @param horse The Horse object to associate with the feeding schedule.
     */
    public void setHorse(Horse horse) {
        this.horse = horse;
    }
}
