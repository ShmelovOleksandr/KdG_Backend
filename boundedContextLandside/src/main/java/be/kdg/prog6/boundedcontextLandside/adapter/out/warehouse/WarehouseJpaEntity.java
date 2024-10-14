package be.kdg.prog6.boundedcontextLandside.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextLandside.adapter.out.seller.SellerJpaEntity;
import be.kdg.prog6.boundedcontextLandside.domain.*;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "warehouses")
public class WarehouseJpaEntity {
    @Id
    @Column(unique = true, nullable = false, columnDefinition = "varchar(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @ManyToOne(optional = false)
    private SellerJpaEntity owner;

    private BigDecimal maxCapacity;
    private BigDecimal currentCapacity;

    @Enumerated(EnumType.STRING)
    private MaterialType materialTypeStored;

    public WarehouseJpaEntity() {
    }

    public WarehouseJpaEntity(UUID id, SellerJpaEntity owner, BigDecimal maxCapacity, BigDecimal currentCapacity, MaterialType materialTypeStored) {
        this.id = id;
        this.owner = owner;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.materialTypeStored = materialTypeStored;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SellerJpaEntity getOwner() {
        return owner;
    }

    public void setOwner(SellerJpaEntity seller) {
        this.owner = seller;
    }

    public BigDecimal getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(BigDecimal maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public BigDecimal getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(BigDecimal currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public MaterialType getMaterialTypeStored() {
        return materialTypeStored;
    }

    public void setMaterialTypeStored(MaterialType materialTypeStored) {
        this.materialTypeStored = materialTypeStored;
    }

    public static WarehouseJpaEntity of(Warehouse warehouse) {
        return new WarehouseJpaEntity(
                warehouse.getWarehouseId().id(),
                SellerJpaEntity.of(warehouse.getOwnerId()),
                warehouse.getMaximumMaterialTons(),
                warehouse.getCurrentlyStoredMaterial().getTons(),
                warehouse.getCurrentlyStoredMaterial().getMaterialType()
        );
    }

    public Warehouse toDomain() {
        return new Warehouse(
                new WarehouseId(this.id),
                new SellerId(this.owner.getId()),
                new Material(this.materialTypeStored, this.currentCapacity),
                this.maxCapacity
        );
    }
}