package be.kdg.prog6.boundedcontextWarehouse.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

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
        //TODO Is is the best solution?
        this.warehouseActivityWindow = new WarehouseActivityWindow(this.id);
    }


    public BigDecimal getCurrentTons() {
        return warehouseActivityWindow.getCurrentTons();
    }

    public WarehouseActivity addMaterialTons(BigDecimal tons) {
        return warehouseActivityWindow.addWarehouseActivity(WarehouseActivityType.INCREASE, tons);
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

    public WarehouseActivityWindow getWarehouseActivityWindow() {
        return warehouseActivityWindow;
    }

    public void setWarehouseActivityWindow(WarehouseActivityWindow warehouseActivityWindow) {
        this.warehouseActivityWindow = warehouseActivityWindow;
    }

    public PDT generatePDT(AppointmentId appointmentId, LocalDateTime deliveryTime) {
        return new PDT(
                new PDTId(UUID.randomUUID()),
                new AppointmentId(appointmentId.id()),
                deliveryTime,
                this.id,
                this.materialTypeStored
        );
    }
}
