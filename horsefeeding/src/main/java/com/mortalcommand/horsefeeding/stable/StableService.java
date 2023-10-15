package com.mortalcommand.horsefeeding.stable;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StableService {

    private StableRepository stableRepository;
    private StableMapper stableMapper;

    private final StableDTOMapper stableDTOMapper;

    public StableService(StableRepository stableRepository, StableMapper stableMapper, StableDTOMapper stableDTOMapper) {
        this.stableRepository = stableRepository;
        this.stableMapper = stableMapper;
        this.stableDTOMapper = stableDTOMapper;
    }

    public List<Stable> findAllStables(){
        return stableRepository.findAll();
    }

    public Optional<Stable> findStableById(Long id){
        return stableRepository.findById(id);
    }

    public Stable findStableByName(String name){
        Optional<Stable> stableOptional = stableRepository.findByName(name);

        Stable stable;
        if(stableOptional.isEmpty()){
            stable = new Stable();
            stable.setName(name);
            stableRepository.save(stable);
        } else {
            stable = stableOptional.get();
        }

        return stable;
    }

    public Stable addNewStable(Stable stable){
        return stableRepository.save(stable);
    }

    public void deleteById(Long id){
        stableRepository.deleteById(id);
    }

    public StableDto updateStableById(Long id, StableDto stableDto){
        Stable stableToUpdate = stableRepository.findById(id).orElseThrow();
        stableToUpdate.setName(stableDto.getName());
        return stableDTOMapper.toDTO(stableToUpdate);
    }
}
