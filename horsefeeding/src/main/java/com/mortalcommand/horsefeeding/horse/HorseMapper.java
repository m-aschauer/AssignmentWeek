package com.mortalcommand.horsefeeding.horse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper interface for converting between Horse and HorseDto objects.
 */
@Mapper(componentModel = "spring")
public interface HorseMapper {

    /**
     * Converts a list of Horse objects to a list of HorseDto objects.
     *
     * @param horses A list of Horse objects to be converted.
     * @return A list of corresponding HorseDto objects.
     */
    List<HorseDto> horsesToHorseDtos(List<Horse> horses);

    /**
     * Converts a HorseDto object to a Horse object with mapping of stableName to stable.name.
     *
     * @param horseDto The HorseDto object to be converted.
     * @return The corresponding Horse object.
     */
    @Mapping(source = "stableName", target = "stable.name")
    Horse horseDtoToHorse(HorseDto horseDto);

    /**
     * Converts a Horse object to a HorseDto object with mapping of stable.name to stableName.
     *
     * @param horse The Horse object to be converted.
     * @return The corresponding HorseDto object.
     */
    @Mapping(source = "stable.name", target = "stableName")
    HorseDto horseToHorseDto(Horse horse);
}
