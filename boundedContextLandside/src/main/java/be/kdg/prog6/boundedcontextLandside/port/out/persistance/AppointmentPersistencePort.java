package be.kdg.prog6.boundedcontextLandside.port.out.persistance;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;

public interface AppointmentPersistencePort {

    Appointment saveAppointment(Appointment appointment);
}
