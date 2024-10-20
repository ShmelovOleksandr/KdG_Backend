package be.kdg.prog6.boundedcontextWarehouse.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PDT {
    private PDTId id;
    private AppointmentId appointmentId;
    private LocalDateTime arrivalTime;
    private WarehouseId warehouseId;
    private MaterialType materialType;
    private BigDecimal deliveredWeigh;

    public PDT() {
    }

    public PDT(PDTId id, AppointmentId appointmentId, LocalDateTime arrivalTime, WarehouseId warehouseId, MaterialType materialType) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.arrivalTime = arrivalTime;
        this.warehouseId = warehouseId;
        this.materialType = materialType;
    }

    public PDT(PDTId id, AppointmentId appointmentId, LocalDateTime arrivalTime, WarehouseId warehouseId, MaterialType materialType, BigDecimal deliveredWeigh) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.arrivalTime = arrivalTime;
        this.warehouseId = warehouseId;
        this.materialType = materialType;
        this.deliveredWeigh = deliveredWeigh;
    }

    public void enrich(BigDecimal weight) {
        this.deliveredWeigh = weight;
    }

    public PDTId getId() {
        return id;
    }

    public void setId(PDTId id) {
        this.id = id;
    }

    public AppointmentId getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(AppointmentId appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public WarehouseId getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(WarehouseId warehouseId) {
        this.warehouseId = warehouseId;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public BigDecimal getDeliveredWeigh() {
        return deliveredWeigh;
    }

    public void setDeliveredWeigh(BigDecimal deliveredWeigh) {
        this.deliveredWeigh = deliveredWeigh;
    }
}
