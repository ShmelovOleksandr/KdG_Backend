package be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WarehouseActivityWindowJpaRepository extends JpaRepository<WarehouseActivityWindowJpaEntity, UUID> {
}
