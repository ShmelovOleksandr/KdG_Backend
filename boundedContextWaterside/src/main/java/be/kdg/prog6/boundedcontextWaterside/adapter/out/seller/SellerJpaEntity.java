package be.kdg.prog6.boundedcontextWaterside.adapter.out.seller;

import be.kdg.prog6.boundedcontextWaterside.domain.Seller;
import be.kdg.prog6.boundedcontextWaterside.domain.SellerId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "sellers")
public class SellerJpaEntity {
    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private UUID sellerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    public SellerJpaEntity() {
    }

    public SellerJpaEntity(UUID sellerId, String name, String address) {
        this.sellerId = sellerId;
        this.name = name;
        this.address = address;
    }

    public Seller toDomain() {
        return new Seller(
                new SellerId(this.sellerId),
                this.name,
                this.address
        );
    }

    public UUID getSellerId() {
        return sellerId;
    }

    public void setSellerId(UUID sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
