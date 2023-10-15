package com.mortalcommand.horsefeeding.horse;

import com.mortalcommand.horsefeeding.stable.Stable;
import com.mortalcommand.horsefeeding.stable.StableRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper class for converting between Horse and HorseDto objects.
 */
@Component
public class HorseDTOMapper {
    private final StableRepository stableRepository;

    public HorseDTOMapper(StableRepository stableRepository) {
        this.stableRepository = stableRepository;
    }

    /**
     * Converts a Horse object to a HorseDto object.
     * @param horse The Horse object to be converted.
     * @return The corresponding HorseDto object.
     */
    public static HorseDto toDTO(Horse horse) {
        HorseDto horseDto = new HorseDto();
        horseDto.setId(horse.getId());
        horseDto.setName(horse.getHorseName());
        horseDto.setNickname(horse.getNickname());
        horseDto.setGuid(horse.getGuid());
        horseDto.setOwner(horse.getOwner());
        horseDto.setBreed(horse.getBreed());
        if (horse.getStable() != null) {
            horseDto.setStableName(horse.getStable().getName());
        }

        return horseDto;
    }

    /**
     * Converts a HorseDto object to a Horse object.
     * @param horseDto The HorseDto object to be converted.
     * @return The corresponding Horse object.
     */
    public Horse toEntity(HorseDto horseDto) {
        Horse horse = new Horse();
        horse.setId(horseDto.getId());
        horse.setHorseName(horseDto.getName());
        horse.setNickname(horseDto.getNickname());
        horse.setGuid(horseDto.getGuid());
        horse.setOwner(horseDto.getOwner());
        horse.setBreed(horseDto.getBreed());

        List<Stable> allStables = stableRepository.findAll();
        if (horseDto.getStableName() != null) {
            Stable stable = new Stable();
            stable.setName(horseDto.getStableName());
            horse.setStable(stable);
        }

        return horse;
    }
}
