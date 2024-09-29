package be.kdg.prog6.boundedcontextWarehouse.adapter.out;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SellerJpaEntity {
    @Id
    @Column(unique = true, nullable = false)
    private UUID id;

    @OneToMany(mappedBy = "seller")
    private List<WarehouseJpaEntity> warehouses;
}
