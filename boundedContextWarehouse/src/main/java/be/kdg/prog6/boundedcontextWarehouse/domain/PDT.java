package be.kdg.prog6.boundedcontextWarehouse.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PDT(PDTId id, LocalDateTime arrivalTime, WarehouseId warehouseId, MaterialType materialType, BigDecimal deliveredWeight) {
}
