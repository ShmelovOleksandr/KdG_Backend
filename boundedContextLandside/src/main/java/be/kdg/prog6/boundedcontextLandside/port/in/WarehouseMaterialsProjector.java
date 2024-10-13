package be.kdg.prog6.boundedcontextLandside.port.in;

import be.kdg.prog6.boundedcontextLandside.domain.Material;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseActivityType;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;

public interface WarehouseMaterialsProjector {

    void projectWarehouse(WarehouseId warehouseId, WarehouseActivityType activityType, Material material);
}
