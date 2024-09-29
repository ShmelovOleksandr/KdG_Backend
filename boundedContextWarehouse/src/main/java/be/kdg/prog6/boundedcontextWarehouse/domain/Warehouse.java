package be.kdg.prog6.boundedcontextWarehouse.domain;

import java.math.BigDecimal;

public class Warehouse {
    private final WarehouseId id;

    private final SellerId ownerId;

    private final BigDecimal maxCapacity;

    private final MaterialType materialTypeStored;

    private ActivityWindow activityWindow;

    public Warehouse(WarehouseId id, SellerId ownerId, BigDecimal maxCapacity, MaterialType materialTypeStored) {
        this.id = id;
        this.ownerId = ownerId;
        this.maxCapacity = maxCapacity;
        this.materialTypeStored = materialTypeStored;
    }


    public BigDecimal getCurrentTons() {
        return activityWindow.getCurrentTons();
    }

    public void addMaterial(Material material) {
        //TODO
        activityWindow.addWarehouseActivity();
    }
}
