package be.kdg.prog6.boundedcontextLandside.port.out.persistance;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;

import java.util.List;

public interface FindAppointmentPort {
    Appointment findAppointmentById(AppointmentId id);
    List<Appointment> findAppointmentsWithArrivalDateNotNullAndDepartureDateNull();
}
