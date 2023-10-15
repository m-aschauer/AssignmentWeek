package com.mortalcommand.horsefeeding.schedule;

import com.mortalcommand.horsefeeding.horse.HorseDto;
import com.mortalcommand.horsefeeding.horse.Horse;
import com.mortalcommand.horsefeeding.horse.HorseService;
import com.mortalcommand.horsefeeding.horse.HorseDTOMapper;
import com.mortalcommand.horsefeeding.horse.HorseRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

@Service
public class ScheduleService {

    private ScheduleMapper scheduleMapper;
    private ScheduleRepository scheduleRepository;
    private HorseService horseService;
    private HorseRepository horseRepository;
    private final HorseDTOMapper horseMapper;

    public ScheduleService(ScheduleMapper scheduleMapper, ScheduleRepository scheduleRepository, HorseService horseService, HorseRepository horseRepository, HorseDTOMapper horseMapper) {
        this.scheduleMapper = scheduleMapper;
        this.scheduleRepository = scheduleRepository;
        this.horseService = horseService;
        this.horseRepository = horseRepository;
        this.horseMapper = horseMapper;
    }


    public List<FeedingSchedule> showAllSchedules(){
        return scheduleRepository.findAll();
    }

    public Optional<FeedingSchedule> findScheduleById(Long id){
        return scheduleRepository.findById(id);
    }

    public FeedingSchedule addNewSchedule(FeedingSchedule schedule){
        return scheduleRepository.save(schedule);
    }

    public void deleteScheduleById(Long id){
        scheduleRepository.deleteById(id);
    }



    public void setScheduleHorse(ScheduleDto scheduleDto, FeedingSchedule feedingSchedule){
        Horse horse = horseService.findByHorseName(scheduleDto.getHorseNickName());
        if (horse == null){
            return;
        }
        feedingSchedule.setHorse(horse);
    }

    public Optional<ScheduleDto> updateSchedule(Long scheduleId, ScheduleDto scheduleDto){
        Optional<FeedingSchedule> scheduleOptionalToUpdate = scheduleRepository.findById(scheduleId);
        if(scheduleOptionalToUpdate.isEmpty()){
            return Optional.empty();
        }

        FeedingSchedule scheduleToUpdate = scheduleOptionalToUpdate.get();
        scheduleToUpdate.setId(scheduleDto.getId());
        scheduleToUpdate.setFeedingStart(scheduleDto.getFeedingStart());
        scheduleToUpdate.setFeedingEnd(scheduleDto.getFeedingEnd());
        Optional<Horse> horse = null;
        return Optional.empty();
    }

    //schedules, die zu gewissen zeitpunkten in frage kommen
    public Optional<ScheduleDto> showEligibleSchedules(TimeDto timeDto) throws ParseException {
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setFeedingStart(timeDto.getTime());
        List<FeedingSchedule> scheduleList = scheduleRepository.findAll();
        Date timeToCheck = new SimpleDateFormat("HH:mm").parse(scheduleDto.getFeedingStart());

        for (FeedingSchedule schedule : scheduleList) {
            Date start = new SimpleDateFormat("HH:mm").parse(schedule.getFeedingStart());
            Date end = new SimpleDateFormat("HH:mm").parse(schedule.getFeedingEnd());
            if (timeToCheck.compareTo(start) == 0 || (timeToCheck.compareTo(start) > 0 && timeToCheck.compareTo(end) < 0)) {
                return Optional.ofNullable(scheduleMapper.feedingScheduleToScheduleDto(schedule));
            }
        }
        return Optional.empty();
    }
    public List<HorseDto> showEligibleHorses(String time){
        LocalTime now = LocalTime.now();
        List<HorseDto> eligibleHorses = null;
        List<HorseDto> allHorses = horseService.showAllHorses();
        LocalTime enteredTime = LocalTime.parse(time);
        for (HorseDto horseDto: allHorses) {
            List<FeedingSchedule> schedulesForThisHorse = findSchedulesForHorse(horseDto);
            for (FeedingSchedule schedule:schedulesForThisHorse){
                if (enteredTime.isAfter(LocalTime.parse(schedule.getFeedingStart())) && enteredTime.isBefore(LocalTime.parse(schedule.getFeedingEnd()))){
                    eligibleHorses.add(horseDto);
                }
            }
        }
        return eligibleHorses;
    }

    //alle schedules für ein bestimmtes horse
    public List<FeedingSchedule> findSchedulesForHorse(HorseDto horseDto){
        List<FeedingSchedule> allSchedules = scheduleRepository.findAll();
        List<FeedingSchedule> schedulesForThisHorse = null;

        for (FeedingSchedule schedule:allSchedules) {
            if(schedule.getHorse().getGuid() == horseDto.getGuid()){
                schedulesForThisHorse.add(schedule);
            }
        }
        return schedulesForThisHorse;
    }
    /*public Optional<List<HorseDto>> showEligibleHorses(String time){
        Optional<List<Horse>> eligibleHorses = Optional.of(new ArrayList<Horse>());
        List<FeedingSchedule> scheduleList = scheduleRepository.findAll();
        long enteredTime = Date.parse(time);
        for (FeedingSchedule schedule : scheduleList){
            long startTime = Long.parseLong(schedule.getFeedingStart());
            long endTime = Long.parseLong(schedule.getFeedingEnd());
            if(enteredTime > startTime && endTime > enteredTime){
                eligibleHorses.get().add(horseRepository.findByGuid(schedule.getHorse().getGuid()).get());
                break;
            }
        }
        if (eligibleHorses.isEmpty()){
            return Optional.empty();
        }
        List<HorseDto> result = horseMapper.horsesToHorseDtos(eligibleHorses);
        if (time.isEmpty()){
            LocalTime localTime = LocalTime.
        }



        ScheduleDto scheduleDto = new ScheduleDto();
        LocalTime enteredTime = LocalTime.parse(time);
        scheduleDto.setFeedingStart(time);


        for (FeedingSchedule schedule : scheduleList){
            LocalTime startFeeding = LocalTime.parse(schedule.getFeedingStart());
            LocalTime endFeeding = LocalTime.parse(schedule.getFeedingEnd());

        }*/

    public Optional<ScheduleDto> showScheduleForFeedingTime(TimeDto timeDto) throws ParseException {
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setFeedingStart((timeDto.getTime()));
        List<FeedingSchedule> scheduleList = scheduleRepository.findAll();
        Date timeToCheck = new SimpleDateFormat("HH:mm").parse(scheduleDto.getFeedingStart());

        for (FeedingSchedule schedule : scheduleList) {
            Date start = new SimpleDateFormat("HH:mm").parse(schedule.getFeedingStart());
            Date end = new SimpleDateFormat("HH:mm").parse(schedule.getFeedingEnd());
            if (timeToCheck.compareTo(start) == 0 || (timeToCheck.compareTo(start) > 0 && timeToCheck.compareTo(end) < 0)) {
                return Optional.ofNullable(scheduleMapper.feedingScheduleToScheduleDto(schedule));
            }
        }
        return Optional.empty();
    }

}
