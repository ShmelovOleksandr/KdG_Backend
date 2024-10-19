package be.kdg.prog6.boundedcontextWarehouse.port.out.persistance;

import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseId;

public interface FindWarehousePort {
    Warehouse findWarehouseById(WarehouseId id);
    Warehouse findWarehouseBySellerAndMaterial(FindWarehouseBySellerAndMaterialCommand findWarehouseBySellerAndMaterialCommand);
}
