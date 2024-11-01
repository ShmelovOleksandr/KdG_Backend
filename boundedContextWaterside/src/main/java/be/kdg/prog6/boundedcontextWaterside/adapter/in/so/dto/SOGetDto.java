package be.kdg.prog6.boundedcontextWaterside.adapter.in.so.dto;

import be.kdg.prog6.boundedcontextWaterside.domain.SO;

import java.time.LocalDate;
import java.util.UUID;

public record SOGetDto(
        UUID id,
        UUID purchaseOrderId,
        String vesselNumber,
        LocalDate estimatedArrivalDate,
        LocalDate estimatedDepartureDate,
        LocalDate actualArrivalDate,
        LocalDate actualDepartureDate,
        LocalDate dateOfInspectionOperationSignature,
        LocalDate dateOfBunkeringOperationSignature
) {
    public static SOGetDto of(SO so) {
        return new SOGetDto(
                so.getId().id(),
                so.getPurchaseOrderId().id(),
                so.getVesselNumber(),
                so.getEstimatedArrivalDate(),
                so.getEstimatedDepartureDate(),
                so.getActualArrivalDate(),
                so.getActualDepartureDate(),
                so.getDateOfInspectionOperationSignature(),
                so.getDateOfBunkeringOperationSignature()
        );
    }
}
