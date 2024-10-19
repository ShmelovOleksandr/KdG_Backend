package be.kdg.prog6.boundedcontextLandside.adapter.in.requests.dto;

import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgeEntranceResponse;

import java.util.UUID;

public record WeightBridgeEntranceResponseDto(UUID warehouseId) {
    public static WeightBridgeEntranceResponseDto of(WeightBridgeEntranceResponse weightBridgeEntranceResponse) {
        return new WeightBridgeEntranceResponseDto(weightBridgeEntranceResponse.warehouseId().id());
    }
}
