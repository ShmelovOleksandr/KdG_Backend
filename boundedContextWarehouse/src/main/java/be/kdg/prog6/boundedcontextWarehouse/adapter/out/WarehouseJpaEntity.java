package be.kdg.prog6.boundedcontextWarehouse.adapter.out;

import be.kdg.prog6.boundedcontextWarehouse.domain.MaterialType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WarehouseJpaEntity {
    @Id
    @Column(unique = true, nullable = false, columnDefinition = "varchar(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @ManyToOne(optional = false)
    private SellerJpaEntity seller;

    private BigDecimal maxCapacity;
    private BigDecimal currentCapacity;
    private MaterialType materialTypeStored;
}
