package be.kdg.prog6.boundedcontextWarehouse.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record WarehouseActivity(WarehouseActivityId warehouseActivityId, WarehouseId warehouseId, WarehouseActivityType warehouseActivityType, BigDecimal tons, LocalDateTime time) {
    public BigDecimal getChangeToTons() {
        return warehouseActivityType == WarehouseActivityType.INCREASE ? tons : tons.negate();
    }

}
