package be.kdg.prog6.boundedcontextLandside.port.out;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;

public interface FindAppointmentPort {
    Appointment findAppointmentById(AppointmentId id);
}
