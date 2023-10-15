package com.mortalcommand.horsefeeding.stable;

import com.mortalcommand.horsefeeding.stable.StableDto;
import com.mortalcommand.horsefeeding.stable.Stable;
import com.mortalcommand.horsefeeding.stable.StableMapper;
import com.mortalcommand.horsefeeding.stable.StableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/stables")
public class StableController {

    private final StableService stableService;
    private final StableMapper stableMapper;

    public StableController(StableService stableService, StableMapper stableMapper) {
        this.stableService = stableService;
        this.stableMapper = stableMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<StableDto>> showAllStables(){
        return ResponseEntity.ok(stableMapper.stablesToStableDto(stableService.findAllStables()));
    }

    @PostMapping("")
    public ResponseEntity<StableDto> addNewStable(@RequestBody StableDto stableDto){
        Stable stable = stableMapper.stableDtoToStable(stableDto);
        stableService.addNewStable(stable);

        return ResponseEntity.ok(stableMapper.stableToStableDto(stable));
    }

    @GetMapping("/{stableId}")
    public ResponseEntity showStable(@PathVariable("stableId") Long id){
        Optional<Stable> stableOptional = stableService.findStableById(id);
        if (stableOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(stableMapper.stableToStableDto(stableOptional.get()));
        }
    }
    @DeleteMapping("/{stableId}")
    public ResponseEntity<StableDto> deleteStableById(@PathVariable("stableId") Long stableId){
        Optional<Stable> stableToDelete = stableService.findStableById(stableId);
        if (stableToDelete.isPresent()){
            stableService.deleteById(stableId);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{stableId}")
    public ResponseEntity<StableDto> updateStableById(@PathVariable("stableId") Long stableId, @RequestBody StableDto stableDto){
        return ResponseEntity.ok(stableService.updateStableById(stableId, stableDto));
    }
}
