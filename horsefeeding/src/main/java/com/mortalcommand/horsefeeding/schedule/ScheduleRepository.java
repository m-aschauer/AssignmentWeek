package com.mortalcommand.horsefeeding.schedule;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<FeedingSchedule, Long> {
}
