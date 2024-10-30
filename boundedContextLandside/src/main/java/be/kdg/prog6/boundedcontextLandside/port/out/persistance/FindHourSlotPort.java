package be.kdg.prog6.boundedcontextLandside.port.out.persistance;

import be.kdg.prog6.boundedcontextLandside.domain.Hour;
import be.kdg.prog6.boundedcontextLandside.domain.HourSlot;

import java.time.LocalDate;

public interface FindHourSlotPort {
    HourSlot findCurrentHourSlot();
    HourSlot findHourSlotByDateAndHour(LocalDate date, Hour hour);
}
