package be.kdg.prog6.boundedcontextLandside.adapter.out;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "sellers")
public class SellerJpaEntity {
    @Id
    @Column(unique = true, nullable = false)
    private UUID id;

    public SellerJpaEntity() {
    }

    public SellerJpaEntity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
