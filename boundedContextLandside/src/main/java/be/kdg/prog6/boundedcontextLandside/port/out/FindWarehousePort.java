package be.kdg.prog6.boundedcontextLandside.port.out;

import be.kdg.prog6.boundedcontextLandside.domain.Warehouse;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;

public interface FindWarehousePort {
    Warehouse findWarehouseById(WarehouseId warehouseId);
}
