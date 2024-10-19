package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto;

import be.kdg.prog6.boundedcontextLandside.domain.EntranceRequest;
import be.kdg.prog6.boundedcontextLandside.domain.LicensePlate;

import java.util.Objects;

public record EntranceRequestPostDto(String licensePlate) {
    public EntranceRequestPostDto {
        Objects.requireNonNull(licensePlate);
    }

    public EntranceRequest toDomain() {
        return new EntranceRequest(
                new LicensePlate(licensePlate)
        );
    }
}
