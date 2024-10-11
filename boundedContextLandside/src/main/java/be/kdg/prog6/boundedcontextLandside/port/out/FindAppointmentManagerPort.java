package be.kdg.prog6.boundedcontextLandside.port.out;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentManager;

public interface FindAppointmentManagerPort {
    AppointmentManager findAppointmentManagerForCurrentDay();
}
