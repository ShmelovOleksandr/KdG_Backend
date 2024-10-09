package be.kdg.prog6.boundedcontextLandside.port.out;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;

public interface AppointmentPersistencePort {

    Appointment saveAppointment(Appointment appointment);
}
