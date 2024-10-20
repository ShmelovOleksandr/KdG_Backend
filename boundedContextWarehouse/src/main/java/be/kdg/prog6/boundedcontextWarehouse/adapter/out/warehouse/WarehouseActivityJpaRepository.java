package be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WarehouseActivityJpaRepository extends JpaRepository<WarehouseActivityJpaEntity, UUID> {
    List<WarehouseActivityJpaEntity> findAllByWarehouseId(UUID warehouseId);
}
