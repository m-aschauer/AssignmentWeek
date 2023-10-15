package com.mortalcommand.horsefeeding.horse;

import com.mortalcommand.horsefeeding.stable.Stable;
import com.mortalcommand.horsefeeding.stable.StableRepository;
import com.mortalcommand.horsefeeding.stable.StableService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class for managing horse-related operations.
 */
@Service
public class HorseService {

    private HorseRepository horseRepository;
    private StableService stableService;

    private HorseMapper horseMapper;
    private StableRepository stableRepository;

    /**
     * Creates a new instance of HorseService.
     *
     * @param horseRepository The repository for managing horses.
     * @param stableService The service for managing stables.
     * @param horseMapper The mapper for converting between Horse and HorseDto objects.
     */
    public HorseService(HorseRepository horseRepository, StableService stableService, HorseMapper horseMapper) {
        this.horseRepository = horseRepository;
        this.stableService = stableService;
        this.horseMapper = horseMapper;
    }

    /**
     * Get a list of all horses.
     *
     * @return A list of HorseDto representing all horses.
     */
    public List<HorseDto> showAllHorses() {
        List<Horse> horses = horseRepository.findAll();
        return horses.stream().map(HorseDTOMapper::toDTO).collect(Collectors.toList());
    }

    /**
     * Find a horse by its identifier.
     *
     * @param id The identifier of the horse to find.
     * @return An Optional containing the found Horse, if it exists.
     */
    public Optional<Horse> findByHorseId(Long id) {
        return horseRepository.findById(id);
    }

    /**
     * Find a horse by its GUID (Global Unique Identifier).
     *
     * @param guid The GUID of the horse to find.
     * @return An Optional containing the found Horse, if it exists.
     */
    public Optional<Horse> findByHorseGuid(String guid) {
        return horseRepository.findByGuid(guid);
    }

    /**
     * Find a horse by its name.
     *
     * @param name The name of the horse to find.
     * @return The found Horse or null if not found.
     */
    public Horse findByHorseName(String name) {
        Optional<Horse> horseOptional = horseRepository.findByHorseName(name);
        return horseOptional.orElse(null);
    }

    /**
     * Add a new horse.
     *
     * @param horse The Horse to be added.
     * @return The added Horse.
     */
    public Horse addNewHorse(Horse horse) {
        return horseRepository.save(horse);
    }

    /**
     * Delete a horse by its identifier.
     *
     * @param id The identifier of the horse to delete.
     */
    public void deleteByHorseId(Long id) {
        horseRepository.deleteById(id);
    }

    /**
     * Delete a horse by its GUID.
     *
     * @param guid The GUID of the horse to delete.
     * @return An Optional containing the deleted HorseDto, if it exists.
     */
    public Optional<HorseDto> deleteByHorseGuid(String guid) {
        Optional<Horse> horseOptionalToDelete = horseRepository.findByGuid(guid);
        if (horseOptionalToDelete.isEmpty()) {
            return Optional.empty();
        }
        Horse horseToDelete = horseOptionalToDelete.get();
        HorseDto result = horseMapper.horseToHorseDto(horseToDelete);
        horseRepository.delete(horseToDelete);
        return Optional.ofNullable(result);
    }

    /**
     * Set the stable for a horse using a HorseDto.
     *
     * @param horseDto The HorseDto containing stable information.
     * @param horse The Horse to set the stable for.
     */
    public void setStable(HorseDto horseDto, Horse horse) {
        Stable stable = stableService.findStableByName(horseDto.getStableName());
        horse.setStable(stable);
    }

    /**
     * Update a horse's information using its GUID.
     *
     * @param guid The GUID of the horse to update.
     * @param horseDto The updated information in a HorseDto.
     * @return An Optional containing the updated HorseDto, if the update is successful.
     */
    public Optional<HorseDto> updateHorseByGuid(String guid, HorseDto horseDto) {
        Optional<Horse> horseOptionalToUpdate = horseRepository.findByGuid(guid);
        if (horseOptionalToUpdate.isEmpty()) {
            return Optional.empty();
        }

        Horse horseToUpdate = horseOptionalToUpdate.get();
        horseToUpdate.setHorseName(horseDto.getName());
        horseToUpdate.setNickname(horseDto.getNickname());
        horseToUpdate.setGuid(horseDto.getGuid());
        horseToUpdate.setOwner(horseDto.getOwner());
        horseToUpdate.setBreed(horseDto.getBreed());
        Optional<Stable> stable = null;

        if (horseDto.getStableName() != null) {
            stable = stableRepository.findByName(horseDto.getStableName());
        }
        if (stable.isPresent()) {
            horseToUpdate.setStable(stable.get());
        } else {
            return Optional.empty();
        }
        horseRepository.save(horseToUpdate);
        return Optional.ofNullable(horseMapper.horseToHorseDto(horseToUpdate));
    }
}
