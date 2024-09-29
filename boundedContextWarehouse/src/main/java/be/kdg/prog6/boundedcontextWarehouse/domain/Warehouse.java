package be.kdg.prog6.boundedcontextWarehouse.domain;

import java.math.BigDecimal;

public class Warehouse {
    private final WarehouseId id;

    private final SellerId ownerId;

    private final BigDecimal maxCapacity;

    private final MaterialType materialTypeStored;

    private WarehouseActivityWindow warehouseActivityWindow;

    public Warehouse(WarehouseId id, SellerId ownerId, BigDecimal maxCapacity, MaterialType materialTypeStored) {
        this.id = id;
        this.ownerId = ownerId;
        this.maxCapacity = maxCapacity;
        this.materialTypeStored = materialTypeStored;
    }


    public BigDecimal getCurrentTons() {
        return warehouseActivityWindow.getCurrentTons();
    }

    public WarehouseActivity addMaterial(Material material) {
        MaterialType materialType = material.materialType();
        if (!materialTypeStored.equals(materialType))
            throw new RuntimeException("Material type (%s) is not stored in this warehouse (%s).".formatted(materialType, id));

        return warehouseActivityWindow.addWarehouseActivity(WarehouseActivityType.INCREASE, material.tons());
    }

    public WarehouseId getId() {
        return id;
    }

    public SellerId getOwnerId() {
        return ownerId;
    }

    public BigDecimal getMaxCapacity() {
        return maxCapacity;
    }

    public MaterialType getMaterialTypeStored() {
        return materialTypeStored;
    }

    public WarehouseActivityWindow getActivityWindow() {
        return warehouseActivityWindow;
    }

    public void setActivityWindow(WarehouseActivityWindow warehouseActivityWindow) {
        this.warehouseActivityWindow = warehouseActivityWindow;
    }
}
