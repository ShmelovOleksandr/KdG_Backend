package be.kdg.prog6.boundedcontextLandside.adapter.in.facility.dto;

import be.kdg.prog6.boundedcontextLandside.dom.FacilityDetail;

import java.util.Objects;

public record FacilityDetailGetDto(Integer currentTruckNumber) {
    public FacilityDetailGetDto {
        Objects.requireNonNull(currentTruckNumber);
    }

    public static FacilityDetailGetDto of(FacilityDetail facilityDetail) {
        return new FacilityDetailGetDto(facilityDetail.currentTruckNumber());
    }
}
