package com.mortalcommand.horsefeeding.event;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * A mapper interface for converting between FeedingEvent and EventDto objects.
 */
@Mapper(componentModel = "spring")
public interface EventMapper {

    /**
     * Convert a list of FeedingEvent objects to a list of EventDto objects.
     *
     * @param events The list of FeedingEvent objects to convert.
     * @return A list of EventDto objects.
     */
    List<EventDto> feedingEventToEventDto(List<FeedingEvent> events);

    /**
     * Convert an EventDto object to a FeedingEvent object.
     *
     * @param eventDto The EventDto object to convert.
     * @return The corresponding FeedingEvent object.
     */
    @Mapping(target = "foodType.name", source = "foodType")
    FeedingEvent eventDtoToFeedingEvent(EventDto eventDto);

    /**
     * Convert a FeedingEvent object to an EventDto object.
     *
     * @param event The FeedingEvent object to convert.
     * @return The corresponding EventDto object.
     */
    @Mapping(target = "horseGuid", source = "horse.guid")
    @Mapping(target = "foodType", source = "foodType.name")
    EventDto feedingEventToEventDto(FeedingEvent event);

    // Additional comments or explanations can be added here if needed.
}
