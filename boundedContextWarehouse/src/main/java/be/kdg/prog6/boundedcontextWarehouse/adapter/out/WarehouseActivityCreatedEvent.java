package be.kdg.prog6.boundedcontextWarehouse.adapter.out;

import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivityType;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseId;

import java.math.BigDecimal;

public record WarehouseActivityCreatedEvent(WarehouseId warehouseId, WarehouseActivityType activityType, BigDecimal tons) {
}
