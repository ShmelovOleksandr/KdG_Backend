package be.kdg.prog6.boundedcontextLandside.adapter.in.warehouse;

import be.kdg.prog6.boundedcontextLandside.domain.Material;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseActivityType;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;


public record WarehouseUpdatedEvent(WarehouseEventId warehouseEventId, WarehouseId warehouseId, WarehouseActivityType activityType, Material material) {
}
