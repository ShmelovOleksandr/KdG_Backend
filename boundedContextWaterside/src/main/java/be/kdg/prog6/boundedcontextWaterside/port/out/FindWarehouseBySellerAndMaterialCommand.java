package be.kdg.prog6.boundedcontextWaterside.port.out;

import be.kdg.prog6.boundedcontextWaterside.domain.MaterialType;
import be.kdg.prog6.boundedcontextWaterside.domain.SellerId;

public record FindWarehouseBySellerAndMaterialCommand(SellerId sellerId, MaterialType materialType) {

}
