package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto;

import be.kdg.prog6.boundedcontextLandside.domain.EntranceRequest;
import be.kdg.prog6.boundedcontextLandside.domain.LicensePlate;

public record EntranceRequestPostDto(String licensePlate) {
    public EntranceRequest toDomain() {
        return new EntranceRequest(
                new LicensePlate(licensePlate)
        );
    }
}
