package be.kdg.prog6.boundedcontextWaterside.port.out;


import be.kdg.prog6.boundedcontextWaterside.domain.OrderItem;
import be.kdg.prog6.boundedcontextWaterside.domain.WarehouseId;

public interface NotifyWarehouseUpdatePort {
    void notifyWarehouseMaterialDecreased(WarehouseId warehouseId, OrderItem orderItem);
}
