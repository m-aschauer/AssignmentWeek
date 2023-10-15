package com.mortalcommand.horsefeeding.horse;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//communiaction with db
public interface HorseRepository extends JpaRepository<Horse, Long> {

    Optional<Horse> findByHorseName(String horseName);

    Optional<Horse> findByGuid(String guid);
}
