package be.kdg.prog6.boundedcontextLandside.domain;

import be.kdg.prog6.boundedcontextLandside.domain.exception.WarehouseMaterialTypeMismatchException;

import java.math.BigDecimal;

public class Warehouse {
    private final static BigDecimal MAX_CAPACITY_TO_MAKE_APPOINTMENT = new BigDecimal(80);
    private WarehouseId warehouseId;
    private SellerId ownerId;
    private Material currentlyStoredMaterial;
    private BigDecimal maximumMaterialTons;

    public Warehouse(WarehouseId warehouseId, SellerId ownerId, Material currentlyStoredMaterial, BigDecimal maximumMaterialTons) {
        this.warehouseId = warehouseId;
        this.ownerId = ownerId;
        this.currentlyStoredMaterial = currentlyStoredMaterial;
        this.maximumMaterialTons = maximumMaterialTons;
    }

    public void updateMaterials(WarehouseActivityType activityType, Material arrievedMaterial) {
        if (currentlyStoredMaterial == null) {
            currentlyStoredMaterial = arrievedMaterial;
        } else if (currentlyStoredMaterial.getMaterialType() != arrievedMaterial.getMaterialType()) {
            throw new WarehouseMaterialTypeMismatchException("Materials update not possible. Material types do not match");
        } else {
            switch (activityType) {
                case INCREASE -> currentlyStoredMaterial.increaseTons(arrievedMaterial.getTons());
                case DECREASE -> currentlyStoredMaterial.decreaseTons(arrievedMaterial.getTons());
            }
        }
    }

    public WarehouseId getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(WarehouseId warehouseId) {
        this.warehouseId = warehouseId;
    }

    public SellerId getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(SellerId ownerId) {
        this.ownerId = ownerId;
    }

    public Material getCurrentlyStoredMaterial() {
        return currentlyStoredMaterial;
    }

    public void setCurrentlyStoredMaterial(Material currentlyStoredMaterial) {
        this.currentlyStoredMaterial = currentlyStoredMaterial;
    }

    public BigDecimal getMaximumMaterialTons() {
        return maximumMaterialTons;
    }

    public void setMaximumMaterialTons(BigDecimal maximumMaterialTons) {
        this.maximumMaterialTons = maximumMaterialTons;
    }

    public boolean materialCanBeStored() {
        return maximumMaterialTons.divide(currentlyStoredMaterial.getTons().multiply(new BigDecimal(100))).compareTo(MAX_CAPACITY_TO_MAKE_APPOINTMENT) == -1;
    }
}
