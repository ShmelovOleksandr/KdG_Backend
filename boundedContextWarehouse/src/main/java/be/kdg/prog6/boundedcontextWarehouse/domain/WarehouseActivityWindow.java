package be.kdg.prog6.boundedcontextWarehouse.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class WarehouseActivityWindow {
    private WarehouseId warehouseId;
    private List<WarehouseActivity> activities;

    public WarehouseActivityWindow(WarehouseId warehouseId, List<WarehouseActivity> activities) {
        this.warehouseId = warehouseId;
        this.activities = activities;
    }

    public BigDecimal getCurrentTons() {
        BigDecimal sum = new BigDecimal(0);
        for (WarehouseActivity activity : activities) {
            sum = sum.add(activity.getChangeToTons());
        }
        return sum;
    }

    public WarehouseActivity addWarehouseActivity(WarehouseActivityType activityType, BigDecimal tons) {
        WarehouseActivityId warehouseActivityId = new WarehouseActivityId(UUID.randomUUID());
        WarehouseActivity warehouseActivity = new WarehouseActivity(
                warehouseActivityId,
                warehouseId,
                activityType,
                tons,
                LocalDateTime.now()
        );
        activities.add(warehouseActivity);
        return warehouseActivity;
    }
}
