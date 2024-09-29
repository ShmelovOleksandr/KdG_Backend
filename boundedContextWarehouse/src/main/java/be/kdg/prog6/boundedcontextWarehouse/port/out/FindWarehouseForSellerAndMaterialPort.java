package be.kdg.prog6.boundedcontextWarehouse.port.out;

import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;

public interface FindWarehouseForSellerAndMaterialPort {
    Warehouse findWarehouseBySellerAndMaterial(FindWarehouseBySellerAndMaterialCommand findWarehouseBySellerAndMaterialCommand);
}
