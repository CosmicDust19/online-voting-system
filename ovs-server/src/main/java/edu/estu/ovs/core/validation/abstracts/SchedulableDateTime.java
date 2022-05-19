package edu.estu.ovs.core.validation.abstracts;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

public interface SchedulableDateTime extends Schedulable<ChronoLocalDateTime<?>> {

    LocalDateTime getStartDate();

    LocalDateTime getEndDate();

}
