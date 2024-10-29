package be.kdg.prog6.boundedcontextWarehouse.port.in;

import be.kdg.prog6.boundedcontextWarehouse.domain.MaterialType;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivityType;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseId;

import java.math.BigDecimal;

public interface WarehouseMaterialsUpdater {
    void updateWarehouse(WarehouseId warehouseId, WarehouseActivityType warehouseActivityType, MaterialType materialType, BigDecimal tons);
}
