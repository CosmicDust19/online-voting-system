package edu.estu.ovs.core.validation.abstracts;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public interface SchedulableDate extends Schedulable<ChronoLocalDate> {

    LocalDate getStartDate();

    LocalDate getEndDate();

}
