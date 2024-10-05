package be.kdg.prog6.boundedcontextWarehouse.adapter.out;

import be.kdg.prog6.boundedcontextWarehouse.domain.MaterialType;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivityWindow;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.List;
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

    private BigDecimal maxCapacity;
    private BigDecimal currentCapacity;

    @Enumerated(EnumType.STRING)
    private MaterialType materialTypeStored;

    @OneToOne
    @JoinColumn(name = "warehouseActivityId", referencedColumnName = "warehouseId")
    private WarehouseActivityWindowJpaEntity warehouseActivityWindow;

    public WarehouseJpaEntity() {
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
}
