package be.kdg.prog6.boundedcontextWaterside.adapter.out.po;

import be.kdg.prog6.boundedcontextWaterside.adapter.out.customer.CustomerJpaEntity;
import be.kdg.prog6.boundedcontextWaterside.adapter.out.seller.SellerJpaEntity;
import be.kdg.prog6.boundedcontextWaterside.adapter.out.so.SOJpaEntity;
import be.kdg.prog6.boundedcontextWaterside.domain.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "POs")
public class POJpaEntity {
    @Id
    @Column(updatable = false, nullable = false, unique = true)
    private UUID poId;

    @OneToOne
    @JoinColumn(name = "soId", referencedColumnName = "soId")
    private SOJpaEntity so;

    @Column(nullable = false)
    private String poNumber;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String vesselNumber;


    @ManyToOne(optional = false)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private CustomerJpaEntity customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sellerId", referencedColumnName = "sellerId")
    private SellerJpaEntity seller;

    @OneToMany(mappedBy = "po")
    private List<OrderItemJpaEntity> orderLines;

    public POJpaEntity() {
    }

    public POJpaEntity(UUID poId) {
        this.poId = poId;
    }

    public POJpaEntity(UUID poId, String poNumber, LocalDate date, String vesselNumber, CustomerJpaEntity customer, SellerJpaEntity seller) {
        this.poId = poId;
        this.poNumber = poNumber;
        this.date = date;
        this.vesselNumber = vesselNumber;
        this.customer = customer;
        this.seller = seller;
    }

    public POJpaEntity(UUID poId, SOJpaEntity so, String poNumber, LocalDate date, String vesselNumber, CustomerJpaEntity customer, SellerJpaEntity seller, List<OrderItemJpaEntity> orderLines) {
        this.poId = poId;
        this.so = so;
        this.poNumber = poNumber;
        this.date = date;
        this.vesselNumber = vesselNumber;
        this.customer = customer;
        this.seller = seller;
        this.orderLines = orderLines;
    }

    public static POJpaEntity of(PO po) {
        POJpaEntity poJpaEntity = new POJpaEntity(
                po.getPoId().id(),
                po.getPoNumber(),
                po.getDate(),
                po.getVesselNumber(),
                CustomerJpaEntity.of(po.getCustomer()),
                SellerJpaEntity.of(po.getSeller())
        );
        List<OrderItemJpaEntity> orderItemJpaEntities = po.getOrderLines().stream().map(OrderItemJpaEntity::of).toList();
        orderItemJpaEntities.forEach(orderItemJpaEntity -> orderItemJpaEntity.setPo(poJpaEntity));
        poJpaEntity.setOrderLines(orderItemJpaEntities);
        poJpaEntity.setSo(SOJpaEntity.of(po.getRespectiveSO()));

        return poJpaEntity;
    }

    public PO toDomain() {
        return new PO(
                this.poNumber,
                new POId(this.poId),
                this.date,
                this.customer.toDomain(),
                this.seller.toDomain(),
                this.vesselNumber,
                this.orderLines.stream().map(OrderItemJpaEntity::toDomain).toList(),
                this.so != null ? this.so.toDomain() : null
        );
    }

    public UUID getPoId() {
        return poId;
    }

    public void setPoId(UUID poId) {
        this.poId = poId;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public SOJpaEntity getSo() {
        return so;
    }

    public void setSo(SOJpaEntity so) {
        this.so = so;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getVesselNumber() {
        return vesselNumber;
    }

    public void setVesselNumber(String vesselNumber) {
        this.vesselNumber = vesselNumber;
    }

    public CustomerJpaEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerJpaEntity customer) {
        this.customer = customer;
    }

    public SellerJpaEntity getSeller() {
        return seller;
    }

    public void setSeller(SellerJpaEntity seller) {
        this.seller = seller;
    }

    public List<OrderItemJpaEntity> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderItemJpaEntity> orderLines) {
        this.orderLines = orderLines;
    }
}
