package be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivityWindow;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "warehouse_activity_windows")
public class WarehouseActivityWindowJpaEntity {
    @Id
    @Column(nullable = false)
    private UUID warehouseId;

    @OneToMany(mappedBy = "warehouseActivityWindow")
    private List<WarehouseActivityJpaEntity> activities;

    public WarehouseActivityWindowJpaEntity() {
    }

    public WarehouseActivityWindowJpaEntity(UUID warehouseId, List<WarehouseActivityJpaEntity> activities) {
        this.warehouseId = warehouseId;
        this.activities = activities;
    }

    public UUID getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(UUID warehouseId) {
        this.warehouseId = warehouseId;
    }

    public List<WarehouseActivityJpaEntity> getActivities() {
        return activities;
    }

    public void setActivities(List<WarehouseActivityJpaEntity> activities) {
        this.activities = activities;
    }

    public static WarehouseActivityWindowJpaEntity of(WarehouseActivityWindow warehouseActivityWindow) {
        return new WarehouseActivityWindowJpaEntity(
                warehouseActivityWindow.getWarehouseId().id(),
                warehouseActivityWindow.getActivities().stream().map(WarehouseActivityJpaEntity::of).collect(Collectors.toList())
        );
    }
}
