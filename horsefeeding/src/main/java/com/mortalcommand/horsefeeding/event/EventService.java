package com.mortalcommand.horsefeeding.event;

import com.mortalcommand.horsefeeding.schedule.ScheduleDto;
import com.mortalcommand.horsefeeding.schedule.FeedingSchedule;
import com.mortalcommand.horsefeeding.schedule.ScheduleRepository;
import com.mortalcommand.horsefeeding.schedule.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing feeding events.
 */
@Service
public class EventService {

    private EventRepository eventRepository;
    private EventMapper eventMapper;
    private ScheduleService scheduleService;
    private ScheduleRepository scheduleRepository;

    /**
     * Get a list of all feeding events.
     *
     * @return A list of FeedingEvent objects representing all events.
     */
    public List<FeedingEvent> showAllEvents() {
        return eventRepository.findAll();
    }

    /**
     * Find a feeding event by its identifier.
     *
     * @param id The identifier of the feeding event to find.
     * @return An Optional containing the found FeedingEvent, if it exists.
     */
    public Optional<FeedingEvent> findEventById(Long id) {
        return eventRepository.findById(id);
    }

    /**
     * Add a new feeding event.
     *
     * @param feedingEvent The FeedingEvent to be added.
     * @return The added FeedingEvent.
     */
    public FeedingEvent addNewEvent(FeedingEvent feedingEvent) {
        return eventRepository.save(feedingEvent);
    }

    /**
     * Delete a feeding event by its identifier.
     *
     * @param id The identifier of the feeding event to delete.
     */
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

    /**
     * Release food to horses based on a feeding schedule.
     *
     * @param time      The feeding time.
     * @param horseGuid The unique identifier (GUID) of the horse.
     * @return A list of EventDto objects representing the events.
     */
    public List<EventDto> releaseFood(String time, String horseGuid) {
        List<EventDto> events = null;
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setFeedingStart(time);
        List<FeedingSchedule> scheduleList = scheduleRepository.findAll();

        //Todo implement logic

        return events;
    }
}
