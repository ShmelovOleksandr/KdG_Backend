package be.kdg.prog6.boundedcontextLandside.port.in;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;

public interface ScheduleAppointmentUseCase {
    Appointment scheduleAppointment(ScheduleAppointmentCommand scheduleAppointmentCommand);
}
