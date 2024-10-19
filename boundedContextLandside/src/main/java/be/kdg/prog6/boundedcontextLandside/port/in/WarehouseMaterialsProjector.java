package be.kdg.prog6.boundedcontextLandside.port.in;

import be.kdg.prog6.boundedcontextLandside.domain.MaterialType;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseActivityType;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;

import java.math.BigDecimal;

public interface WarehouseMaterialsProjector {

    void projectWarehouse(WarehouseId warehouseId, WarehouseActivityType activityType, MaterialType materialType, BigDecimal tons);
}
