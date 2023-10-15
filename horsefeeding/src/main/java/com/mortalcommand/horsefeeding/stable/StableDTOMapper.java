package com.mortalcommand.horsefeeding.stable;

import org.springframework.stereotype.Component;

@Component
public class StableDTOMapper {

    public StableDto toDTO(Stable stable){
        StableDto stableDto = new StableDto();
        stableDto.setId(stable.getId());
        stableDto.setName(stable.getName());
        return stableDto;
    }

    public Stable toEntity(StableDto stableDto){
        Stable stable = new Stable();
        stable.setId(stableDto.getId());
        stable.setName(stableDto.getName());
        return stable;
    }
}
