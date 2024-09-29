package be.kdg.prog6.boundedcontextWarehouse.domain;

import java.math.BigDecimal;
import java.util.List;

public class ActivityWindow {
    private List<WarehouseActivity> activities;

    public BigDecimal getCurrentTons() {
        BigDecimal sum = new BigDecimal(0);
        for (WarehouseActivity activity : activities) {
            sum.add()
        }
    }

    public void addWarehouseActivity(WarehouseActivity warehouseActivity) {
        activities.add(warehouseActivity);
    }
}
