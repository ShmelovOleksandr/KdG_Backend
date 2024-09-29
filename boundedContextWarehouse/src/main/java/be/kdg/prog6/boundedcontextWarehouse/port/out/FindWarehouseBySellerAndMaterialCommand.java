package be.kdg.prog6.boundedcontextWarehouse.port.out;

import be.kdg.prog6.boundedcontextWarehouse.domain.MaterialType;
import be.kdg.prog6.boundedcontextWarehouse.domain.SellerId;

public record FindWarehouseBySellerAndMaterialCommand(SellerId sellerId, MaterialType materialType) {
}
