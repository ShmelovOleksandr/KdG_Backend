package be.kdg.prog6.boundedcontextLandside.port.out.persistance;

import be.kdg.prog6.boundedcontextLandside.domain.MaterialType;
import be.kdg.prog6.boundedcontextLandside.domain.SellerId;
import be.kdg.prog6.boundedcontextLandside.domain.Warehouse;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;

public interface FindWarehousePort {
    Warehouse findWarehouseById(WarehouseId warehouseId);
    Warehouse findWarehouseBySellerIdAndMaterialTypeStored(SellerId sellerId, MaterialType materialTypeStored);
}
