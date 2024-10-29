package be.kdg.prog6.boundedcontextWaterside.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextWaterside.adapter.out.seller.SellerJpaEntity;
import be.kdg.prog6.boundedcontextWaterside.domain.MaterialType;
import be.kdg.prog6.boundedcontextWaterside.domain.SellerId;
import be.kdg.prog6.boundedcontextWaterside.domain.Warehouse;
import be.kdg.prog6.boundedcontextWaterside.domain.WarehouseId;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "warehouses")
public class WarehouseJpaEntity {
    @Id
    @Column(nullable = false, updatable = false, unique = true)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MaterialType materialType;

    @ManyToOne
    @JoinColumn(name = "ownerId", referencedColumnName = "sellerId")
    private SellerJpaEntity owner;

    public WarehouseJpaEntity() {
    }

    public WarehouseJpaEntity(UUID id, MaterialType materialType, SellerJpaEntity owner) {
        this.id = id;
        this.materialType = materialType;
        this.owner = owner;
    }

    public Warehouse toDomain() {
        return new Warehouse(
                new WarehouseId(this.id),
                new SellerId(this.owner.getSellerId()),
                this.materialType
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public SellerJpaEntity getOwner() {
        return owner;
    }

    public void setOwner(SellerJpaEntity owner) {
        this.owner = owner;
    }
}
