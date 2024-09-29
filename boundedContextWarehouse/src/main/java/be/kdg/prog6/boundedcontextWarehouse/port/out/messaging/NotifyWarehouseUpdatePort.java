package be.kdg.prog6.boundedcontextWarehouse.port.out.messaging;

import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivity;

public interface NotifyWarehouseUpdatePort {
    void notifyWarehouseUpdated(Warehouse warehouse, WarehouseActivity warehouseActivity);
}
