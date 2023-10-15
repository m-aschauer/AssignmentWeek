package com.mortalcommand.horsefeeding.schedule;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper interface for converting between feeding schedules and their Data Transfer Objects (DTOs).
 */
@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    /**
     * Convert a list of feeding schedules to a list of schedule DTOs.
     *
     * @param schedules A list of feeding schedules to be converted.
     * @return A list of corresponding schedule DTOs.
     */
    List<ScheduleDto> feedingSchedulesToScheduleDto(List<FeedingSchedule> schedules);

    /**
     * Convert a schedule DTO to a feeding schedule.
     *
     * @param scheduleDto The schedule DTO to be converted.
     * @return The corresponding feeding schedule.
     */
    FeedingSchedule scheduleDtoToFeedingSchedule(ScheduleDto scheduleDto);

    /**
     * Convert a feeding schedule to a schedule DTO.
     *
     * @param schedule The feeding schedule to be converted.
     * @return The corresponding schedule DTO.
     */
    @Mapping(target = "horseNickName", source = "horse.nickname")
    @Mapping(target = "horseGuid", source = "horse.guid")
    ScheduleDto feedingScheduleToScheduleDto(FeedingSchedule schedule);
}
