package be.kdg.prog6.boundedcontextLandside.adapter.in.requests.dto;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.port.in.DepartureCommand;

import java.util.Objects;
import java.util.UUID;

public record DepartureRequestPostDto(UUID appointmentId) {
    public DepartureRequestPostDto {
        Objects.requireNonNull(appointmentId);
    }

    public DepartureCommand toDepartureCommand() {
        return new DepartureCommand(
                new AppointmentId(appointmentId)
        );
    }
}
