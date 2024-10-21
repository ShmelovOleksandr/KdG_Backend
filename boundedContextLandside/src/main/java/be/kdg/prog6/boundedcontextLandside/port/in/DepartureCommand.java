package be.kdg.prog6.boundedcontextLandside.port.in;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;

public record DepartureCommand(AppointmentId appointmentId) {
}
