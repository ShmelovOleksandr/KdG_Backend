package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto;

import be.kdg.prog6.boundedcontextLandside.domain.EntranceRequest;
import be.kdg.prog6.boundedcontextLandside.domain.LicensePlate;
import be.kdg.prog6.boundedcontextLandside.domain.MaterialType;

import java.util.Objects;

public record EntranceRequestPostDto(String licensePlate, MaterialType materialType) {
    public EntranceRequestPostDto {
        Objects.requireNonNull(licensePlate);
        Objects.requireNonNull(materialType);
    }

    public EntranceRequest toDomain() {
        return new EntranceRequest(
                new LicensePlate(licensePlate),
                materialType
        );
    }
}
