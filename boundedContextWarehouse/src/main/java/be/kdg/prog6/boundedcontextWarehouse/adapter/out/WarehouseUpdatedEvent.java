package be.kdg.prog6.boundedcontextWarehouse.adapter.out;

import be.kdg.prog6.boundedcontextWarehouse.domain.Material;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivityType;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseId;

import java.math.BigDecimal;

public record WarehouseUpdatedEvent(WarehouseEventId warehouseEventId, WarehouseId warehouseId, WarehouseActivityType activityType, Material material) {
}
