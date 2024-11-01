package be.kdg.prog6.boundedcontextWaterside.adapter.in.so.dto;

import be.kdg.prog6.boundedcontextWaterside.domain.POId;
import be.kdg.prog6.boundedcontextWaterside.domain.SO;
import be.kdg.prog6.boundedcontextWaterside.domain.SOId;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public record SOPostDto(
        UUID purchaseOrderId,
        String vesselNumber,
        LocalDate estimatedArrivalDate,
        LocalDate estimatedDepartureDate
) {

    public SOPostDto {
        Objects.requireNonNull(purchaseOrderId);
        Objects.requireNonNull(vesselNumber);
        Objects.requireNonNull(estimatedArrivalDate);
        Objects.requireNonNull(estimatedDepartureDate);
    }

    public SO toDomain() {
        return new SO(
                new SOId(UUID.randomUUID()),
                new POId(this.purchaseOrderId),
                this.vesselNumber,
                this.estimatedArrivalDate,
                this.estimatedDepartureDate
        );
    }
}
