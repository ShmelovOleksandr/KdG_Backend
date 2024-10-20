package be.kdg.prog6.boundedcontextLandside.adapter.in.requests.dto;

import be.kdg.prog6.boundedcontextLandside.domain.LicensePlate;
import be.kdg.prog6.boundedcontextLandside.port.in.DepartureCommand;

import java.util.Objects;

public record ExitRequestPostDto(String licensePlate) {
    public ExitRequestPostDto {
        Objects.requireNonNull(licensePlate);
    }

    public DepartureCommand toDepartureCommand() {
        return new DepartureCommand(new LicensePlate(licensePlate));
    }
}
