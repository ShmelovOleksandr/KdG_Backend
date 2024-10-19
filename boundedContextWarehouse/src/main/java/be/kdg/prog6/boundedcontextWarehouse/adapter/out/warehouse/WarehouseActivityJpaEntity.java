package be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivity;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivityType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "warehouse_activities")
public class WarehouseActivityJpaEntity {
    @Id
    private UUID id;

    private UUID warehouseId;
    @Enumerated(EnumType.STRING)
    private WarehouseActivityType type;

    private BigDecimal tons;

    @ManyToOne
    private WarehouseActivityWindowJpaEntity warehouseActivityWindow;

    public WarehouseActivityJpaEntity() {
    }

    public WarehouseActivityJpaEntity(UUID id, UUID warehouseId, WarehouseActivityType type, BigDecimal tons) {
        this.id = id;
        this.warehouseId = warehouseId;
        this.type = type;
        this.tons = tons;
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

    public static WarehouseActivityJpaEntity of(WarehouseActivity warehouseActivity) {
        return new WarehouseActivityJpaEntity(
                warehouseActivity.warehouseActivityId().id(),
                warehouseActivity.warehouseId().id(),
                warehouseActivity.warehouseActivityType(),
                warehouseActivity.tons()
        );
    }
}
