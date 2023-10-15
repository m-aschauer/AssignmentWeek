package com.mortalcommand.horsefeeding.event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<FeedingEvent, Long> {
}
