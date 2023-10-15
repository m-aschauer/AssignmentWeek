package com.mortalcommand.horsefeeding.horse;

import com.mortalcommand.horsefeeding.horse.HorseDto;
import com.mortalcommand.horsefeeding.horse.Horse;
import com.mortalcommand.horsefeeding.horse.HorseDTOMapper;
import com.mortalcommand.horsefeeding.horse.HorseMapper;
import com.mortalcommand.horsefeeding.horse.HorseService;
import com.mortalcommand.horsefeeding.stable.StableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for managing horse-related operations.
 */
@RestController
@RequestMapping("api/v1/horses")
public class HorseController {
    private final HorseService horseService;
    private final HorseMapper horseMapper;
    private final StableService stableService;
    private final HorseDTOMapper horseDTOMapper;

    public HorseController(HorseService horseService, HorseMapper horseMapper, StableService stableService, HorseDTOMapper horseDTOMapper) {
        this.horseService = horseService;
        this.horseMapper = horseMapper;
        this.stableService = stableService;
        this.horseDTOMapper = horseDTOMapper;
    }

    /**
     * Get a list of all horses.
     * @return A ResponseEntity containing a list of HorseDto.
     */
    @GetMapping("")
    public ResponseEntity<List<HorseDto>> showAllHorses(){
        return ResponseEntity.ok(horseService.showAllHorses());
    }

    /**
     * Add a new horse.
     * @param horseDto The HorseDto containing horse information.
     * @return A ResponseEntity containing the added Horse.
     */
    @PostMapping("")
    public ResponseEntity<Horse> addNewHorse(@RequestBody HorseDto horseDto){
        Horse horse = horseDTOMapper.toEntity(horseDto);

        System.out.println(horse.getStable().getName());

        return ResponseEntity.ok(horseService.addNewHorse(horse));
    }

    /**
     * Delete a horse by its unique identifier.
     * @param horseGuid The unique identifier of the horse to delete.
     * @return A ResponseEntity indicating the result of the deletion.
     */
    @DeleteMapping("/{horseId}")
    public ResponseEntity<HorseDto> deleteHorse(@PathVariable("horseId") String horseGuid){
        Optional<Horse> horsetoDelete = horseService.findByHorseGuid(horseGuid);
        if (horsetoDelete.isPresent()) {
            horseService.deleteByHorseGuid(horseGuid);
        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

    /**
     * Get information about a horse by its identifier.
     * @param id The identifier of the horse to retrieve.
     * @return A ResponseEntity containing the HorseDto.
     */
    @GetMapping("/{horseId}")
    public ResponseEntity<HorseDto> showHorse(@PathVariable("horseId") Long id) {
        Optional<Horse> optionalHorse = horseService.findByHorseId(id);
        if (optionalHorse.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(horseMapper.horseToHorseDto(optionalHorse.get()));
        }
    }}

    /*@GetMapping("/{horseId}")
    public ResponseEntity showHorse(@PathVariable("horseId"))

    public List<HorseDto> addHorse(HorseDto horseDto){
        String stableName = horseDto.getStable();
        Optional<Stable> stableOptional = stableService.findByName(stableName);

        Stable stable;
        if (stableOptional.isEmpty()) {
            stable = new Stable();
            stable.setName(stableName);
            stableRepository.save(stable);
        } else {
            stable = stableOptional.get();
*/
