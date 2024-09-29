package be.kdg.prog6.boundedcontextWarehouse.port.in;

import be.kdg.prog6.boundedcontextWarehouse.domain.Material;
import be.kdg.prog6.boundedcontextWarehouse.domain.MaterialType;
import be.kdg.prog6.boundedcontextWarehouse.domain.SellerId;

import java.math.BigDecimal;

public record ReceiveMaterialCommand(SellerId sellerId, Material material) {
}
