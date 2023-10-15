package com.mortalcommand.horsefeeding.schedule;

import com.mortalcommand.horsefeeding.schedule.ScheduleDto;
import com.mortalcommand.horsefeeding.schedule.FeedingSchedule;
import com.mortalcommand.horsefeeding.schedule.ScheduleMapper;
import com.mortalcommand.horsefeeding.schedule.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleMapper scheduleMapper;

    public ScheduleController(ScheduleService scheduleService, ScheduleMapper scheduleMapper) {
        this.scheduleService = scheduleService;
        this.scheduleMapper = scheduleMapper;
    }

    /**
     * Retrieve a list of feeding schedules for horses.
     *
     * @return ResponseEntity containing a list of ScheduleDto objects.
     */
    @GetMapping("")
    public ResponseEntity<List<ScheduleDto>> showHorsesSchedule() {
        return ResponseEntity.ok(scheduleMapper.feedingSchedulesToScheduleDto(scheduleService.showAllSchedules()));
    }

    /**
     * Add a new feeding schedule.
     *
     * @param scheduleDto The feeding schedule information in ScheduleDto format.
     * @return ResponseEntity containing the added ScheduleDto if successful; otherwise, a not found response.
     */
    @PostMapping("")
    public ResponseEntity<ScheduleDto> addNewSchedule(@RequestBody ScheduleDto scheduleDto) {
        FeedingSchedule feedingSchedule = scheduleMapper.scheduleDtoToFeedingSchedule(scheduleDto);
        scheduleService.setScheduleHorse(scheduleDto, feedingSchedule);

        if (feedingSchedule.getHorse() == null || feedingSchedule.getFeedingStart() == null || feedingSchedule.getFeedingEnd() == null) {
            return ResponseEntity.notFound().build();
        }

        FeedingSchedule result = scheduleService.addNewSchedule(feedingSchedule);

        if (result == null || result.getFeedingStart() == null || result.getFeedingEnd() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(scheduleMapper.feedingScheduleToScheduleDto(result));
    }

    /**
     * Retrieve a feeding schedule by its ID.
     *
     * @param id The ID of the feeding schedule to retrieve.
     * @return ResponseEntity containing the ScheduleDto if found; otherwise, a not found response.
     */
    @GetMapping("/{scheduleId}")
    public ResponseEntity showScheduleById(@PathVariable("scheduleId") Long id) {
        Optional<FeedingSchedule> scheduleOptional = scheduleService.findScheduleById(id);

        if (scheduleOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(scheduleMapper.feedingScheduleToScheduleDto(scheduleOptional.get()));
        }
    }

    /**
     * Delete a feeding schedule by its ID.
     *
     * @param id The ID of the feeding schedule to delete.
     * @return ResponseEntity with a no content response if the schedule is successfully deleted; otherwise, a not found response.
     */
    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<ScheduleDto> deleteSchedule(@PathVariable("scheduleId") Long id) {
        Optional<FeedingSchedule> scheduleToDelete = scheduleService.findScheduleById(id);

        if (scheduleToDelete.isPresent()) {
            scheduleService.deleteScheduleById(id);
        } else {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
