package be.kdg.prog6.boundedcontextWaterside.adapter.out.po;

import be.kdg.prog6.boundedcontextWaterside.domain.MaterialType;
import be.kdg.prog6.boundedcontextWaterside.domain.OrderItem;
import be.kdg.prog6.boundedcontextWaterside.domain.UOM;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "oreder_items")
public class OrderItemJpaEntity {
    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private UUID orderItemId;

    @Column(nullable = false)
    private int lineNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaterialType materialType;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UOM uom;

    @ManyToOne(optional = false)
    @JoinColumn(name = "poId", referencedColumnName = "poId")
    private POJpaEntity po;

    public OrderItemJpaEntity() {
    }

    public OrderItemJpaEntity(int lineNumber, MaterialType materialType, String description, int quantity, UOM uom) {
        this.lineNumber = lineNumber;
        this.materialType = materialType;
        this.description = description;
        this.quantity = quantity;
        this.uom = uom;
    }

    public OrderItemJpaEntity(UUID orderItemId, int lineNumber, MaterialType materialType, String description, int quantity, UOM uom, POJpaEntity po) {
        this.orderItemId = orderItemId;
        this.lineNumber = lineNumber;
        this.materialType = materialType;
        this.description = description;
        this.quantity = quantity;
        this.uom = uom;
        this.po = po;
    }

    public UUID getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(UUID orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UOM getUom() {
        return uom;
    }

    public void setUom(UOM uom) {
        this.uom = uom;
    }

    public POJpaEntity getPo() {
        return po;
    }

    public void setPo(POJpaEntity po) {
        this.po = po;
    }

    public OrderItem toDomain() {
        return new OrderItem(
                this.lineNumber,
                this.materialType,
                this.description,
                this.quantity,
                this.uom
        );
    }

    public static OrderItemJpaEntity of(OrderItem orderItem) {
        return new OrderItemJpaEntity(
                orderItem.lineNumber(),
                orderItem.materialType(),
                orderItem.description(),
                orderItem.quantity(),
                orderItem.uom()
        );
    }
}
