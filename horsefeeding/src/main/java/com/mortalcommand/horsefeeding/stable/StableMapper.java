package com.mortalcommand.horsefeeding.stable;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StableMapper {
    List<StableDto> stablesToStableDto(List<Stable> stables);
    StableDto stableToStableDto(Stable stable);
    Stable stableDtoToStable(StableDto stableDto);
}
