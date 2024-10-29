package be.kdg.prog6.boundedcontextWaterside.domain;

public class Warehouse {
    private WarehouseId warehouseId;
    private SellerId ownerId;
    private MaterialType materialType;

    public Warehouse(WarehouseId warehouseId, SellerId ownerId, MaterialType materialType) {
        this.warehouseId = warehouseId;
        this.ownerId = ownerId;
        this.materialType = materialType;
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

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }
}
