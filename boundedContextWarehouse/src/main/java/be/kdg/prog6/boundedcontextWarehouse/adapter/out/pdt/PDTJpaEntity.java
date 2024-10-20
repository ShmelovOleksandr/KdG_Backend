package be.kdg.prog6.boundedcontextWarehouse.adapter.out.pdt;

import be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse.WarehouseJpaEntity;
import be.kdg.prog6.boundedcontextWarehouse.domain.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "PDTs")
public class PDTJpaEntity {
    @Id
    @Column(unique = true, nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private UUID appointmentId;

    @Column(nullable = false)
    private LocalDateTime arrivalTime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaterialType materialType;

    @Column
    private BigDecimal deliveredWeigh;

    @ManyToOne(fetch = FetchType.LAZY)
    private WarehouseJpaEntity warehouse;

    public PDTJpaEntity() {
    }

    public PDTJpaEntity(UUID id, UUID appointmentId, LocalDateTime arrivalTime, MaterialType materialType, BigDecimal deliveredWeigh, WarehouseJpaEntity warehouse) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.arrivalTime = arrivalTime;
        this.materialType = materialType;
        this.deliveredWeigh = deliveredWeigh;
        this.warehouse = warehouse;
    }

    public static PDTJpaEntity of(PDT pdt) {
        return new PDTJpaEntity(
                pdt.getId().id(),
                pdt.getAppointmentId().id(),
                pdt.getArrivalTime(),
                pdt.getMaterialType(),
                pdt.getDeliveredWeigh(),
                new WarehouseJpaEntity(pdt.getWarehouseId().id())
        );
    }

    public PDT toDomain() {
        return new PDT(
                new PDTId(this.id),
                new AppointmentId(this.appointmentId),
                this.arrivalTime,
                new WarehouseId(this.warehouse.getId()),
                this.materialType,
                this.deliveredWeigh
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
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

    public WarehouseJpaEntity getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseJpaEntity warehouse) {
        this.warehouse = warehouse;
    }
}
