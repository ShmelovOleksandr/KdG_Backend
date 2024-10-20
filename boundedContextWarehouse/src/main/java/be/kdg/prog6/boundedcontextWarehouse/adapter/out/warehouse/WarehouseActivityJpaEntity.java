package be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextWarehouse.domain.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "warehouse_activities")
public class WarehouseActivityJpaEntity {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private UUID warehouseId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WarehouseActivityType type;

    @Column(nullable = false)
    private BigDecimal tons;

    @Column(nullable = false)
    private LocalDateTime time;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "warehouse_window_id", referencedColumnName = "warehouseId")
    private WarehouseActivityWindowJpaEntity warehouseActivityWindow;

    public WarehouseActivityJpaEntity() {
    }

    public WarehouseActivityJpaEntity(UUID id, UUID warehouseId, WarehouseActivityType type, BigDecimal tons, LocalDateTime time) {
        this.id = id;
        this.warehouseId = warehouseId;
        this.type = type;
        this.tons = tons;
        this.time = time;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(UUID warehouseId) {
        this.warehouseId = warehouseId;
    }

    public WarehouseActivityType getType() {
        return type;
    }

    public void setType(WarehouseActivityType type) {
        this.type = type;
    }

    public BigDecimal getTons() {
        return tons;
    }

    public void setTons(BigDecimal tons) {
        this.tons = tons;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public WarehouseActivityWindowJpaEntity getWarehouseActivityWindow() {
        return warehouseActivityWindow;
    }

    public void setWarehouseActivityWindow(WarehouseActivityWindowJpaEntity warehouseActivityWindow) {
        this.warehouseActivityWindow = warehouseActivityWindow;
    }

    public static WarehouseActivityJpaEntity of(WarehouseActivity warehouseActivity) {
        return new WarehouseActivityJpaEntity(
                warehouseActivity.warehouseActivityId().id(),
                warehouseActivity.warehouseId().id(),
                warehouseActivity.warehouseActivityType(),
                warehouseActivity.tons(),
                warehouseActivity.time()
        );
    }

    public WarehouseActivity toDomain() {
        return new WarehouseActivity(
                new WarehouseActivityId(this.id),
                new WarehouseId(this.warehouseId),
                this.type,
                this.tons,
                this.time
        );
    }
}
