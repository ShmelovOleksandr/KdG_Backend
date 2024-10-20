package be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextWarehouse.adapter.out.seller.SellerJpaEntity;
import be.kdg.prog6.boundedcontextWarehouse.domain.MaterialType;
import be.kdg.prog6.boundedcontextWarehouse.domain.SellerId;
import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseId;
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
    private SellerJpaEntity seller;

    @Column(nullable = false)
    private BigDecimal maxCapacity;

    private BigDecimal currentCapacity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaterialType materialTypeStored;

    @OneToOne
    @JoinColumn(name = "warehouseActivityWindowId", referencedColumnName = "warehouseId")
    private WarehouseActivityWindowJpaEntity warehouseActivityWindow;

    public WarehouseJpaEntity() {
    }

    public WarehouseJpaEntity(UUID id) {
        this.id = id;
    }

    public WarehouseJpaEntity(UUID id, SellerJpaEntity seller, BigDecimal maxCapacity, BigDecimal currentCapacity, MaterialType materialTypeStored, WarehouseActivityWindowJpaEntity warehouseActivityWindow) {
        this.id = id;
        this.seller = seller;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.materialTypeStored = materialTypeStored;
        this.warehouseActivityWindow = warehouseActivityWindow;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SellerJpaEntity getSeller() {
        return seller;
    }

    public void setSeller(SellerJpaEntity seller) {
        this.seller = seller;
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

    public WarehouseActivityWindowJpaEntity getWarehouseActivityWindow() {
        return warehouseActivityWindow;
    }

    public void setWarehouseActivityWindow(WarehouseActivityWindowJpaEntity warehouseActivityWindow) {
        this.warehouseActivityWindow = warehouseActivityWindow;
    }

    public static WarehouseJpaEntity of(Warehouse warehouse) {
        return new WarehouseJpaEntity(
                warehouse.getId().id(),
                SellerJpaEntity.of(warehouse.getOwnerId().id()),
                warehouse.getMaxCapacity(),
                warehouse.getCurrentTons(),
                warehouse.getMaterialTypeStored(),
                WarehouseActivityWindowJpaEntity.of(warehouse.getWarehouseActivityWindow())
        );
    }

    public Warehouse toDomain() {
        return new Warehouse(
                new WarehouseId(this.id),
                new SellerId(this.seller.getId()),
                this.maxCapacity,
                this.materialTypeStored
        );
    }
}
