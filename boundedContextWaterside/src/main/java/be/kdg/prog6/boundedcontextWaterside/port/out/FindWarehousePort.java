package be.kdg.prog6.boundedcontextWaterside.port.out;

import be.kdg.prog6.boundedcontextWaterside.domain.Warehouse;

public interface FindWarehousePort {
    Warehouse findWarehouseBySellerAndMaterial(FindWarehouseBySellerAndMaterialCommand findWarehouseBySellerAndMaterialCommand);

}
