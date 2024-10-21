package be.kdg.prog6.boundedcontextLandside.port.out.persistance;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;

public interface PersistAppointmentPort {

    Appointment save(Appointment appointment);
}
