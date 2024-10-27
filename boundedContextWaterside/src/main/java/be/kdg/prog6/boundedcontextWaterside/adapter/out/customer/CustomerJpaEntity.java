package be.kdg.prog6.boundedcontextWaterside.adapter.out.customer;

import be.kdg.prog6.boundedcontextWaterside.domain.Customer;
import be.kdg.prog6.boundedcontextWaterside.domain.CustomerId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "customers")
public class CustomerJpaEntity {
    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private UUID customerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    public CustomerJpaEntity() {
    }

    public CustomerJpaEntity(UUID customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
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

    public Customer toDomain() {
        return new Customer(
                new CustomerId(this.customerId),
                this.name,
                this.address
        );
    }
}
