package be.kdg.prog6.boundedcontextLandside.port.out.persistance;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentManager;

import java.time.LocalDate;

public interface FindAppointmentManagerPort {
    AppointmentManager findAppointmentManagerForDate(LocalDate date);
}
