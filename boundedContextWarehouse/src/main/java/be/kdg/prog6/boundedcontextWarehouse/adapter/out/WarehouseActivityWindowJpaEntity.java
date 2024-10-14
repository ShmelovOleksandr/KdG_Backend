package be.kdg.prog6.boundedcontextWarehouse.adapter.out;

import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivityWindow;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "warehouse_activity_windows")
public class WarehouseActivityWindowJpaEntity {
    @Id
    private UUID warehouseId;

    @OneToMany
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
