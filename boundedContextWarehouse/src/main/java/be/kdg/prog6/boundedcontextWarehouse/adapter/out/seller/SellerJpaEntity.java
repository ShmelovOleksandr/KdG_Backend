package be.kdg.prog6.boundedcontextWarehouse.adapter.out.seller;

import be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse.WarehouseJpaEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "sellers")
public class SellerJpaEntity {
    @Id
    @Column(unique = true, nullable = false)
    private UUID id;

    @OneToMany(mappedBy = "seller")
    private List<WarehouseJpaEntity> warehouses;

    public SellerJpaEntity() {
    }

    public SellerJpaEntity(UUID id) {
        this.id = id;
    }

    public SellerJpaEntity(UUID id, List<WarehouseJpaEntity> warehouses) {
        this.id = id;
        this.warehouses = warehouses;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<WarehouseJpaEntity> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<WarehouseJpaEntity> warehouses) {
        this.warehouses = warehouses;
    }

    public static SellerJpaEntity of(UUID sellerId) {
        return new SellerJpaEntity(sellerId);
    }
}
