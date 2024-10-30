package be.kdg.prog6.boundedcontextLandside.port.in;

import be.kdg.prog6.boundedcontextLandside.domain.Hour;
import be.kdg.prog6.boundedcontextLandside.domain.HourSlot;

import java.time.LocalDate;

public interface GetHourSlotDetailsUseCase {

    HourSlot getHourSlotDetailsForDateAndHour(LocalDate date, Hour hour);
}
