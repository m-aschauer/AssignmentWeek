package com.mortalcommand.horsefeeding.stable;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StableRepository extends JpaRepository<Stable, Long> {
    Optional<Stable> findByName(String name);
}
