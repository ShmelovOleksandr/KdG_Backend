package be.kdg.prog6.boundedcontextLandside.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextLandside.domain.Warehouse;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;
import be.kdg.prog6.boundedcontextLandside.port.out.FindWarehousePort;
import be.kdg.prog6.boundedcontextLandside.port.out.WarehouseUpdatePort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WarehouseDatabaseAdapter implements FindWarehousePort, WarehouseUpdatePort  {
    private final WarehouseJpaRepository warehouseJpaRepository;

    @Autowired
    public WarehouseDatabaseAdapter(WarehouseJpaRepository warehouseJpaRepository) {
        this.warehouseJpaRepository = warehouseJpaRepository;
    }


    @Override
    public void updateWarehouse(Warehouse warehouse) {
        WarehouseJpaEntity warehouseJpaEntity = WarehouseJpaEntity.of(warehouse);
        warehouseJpaRepository.save(warehouseJpaEntity);
    }

    @Override
    public Warehouse findWarehouseById(WarehouseId warehouseId) {
        WarehouseJpaEntity warehouseJpaEntity = warehouseJpaRepository.findByIdWithOwnerFetched(warehouseId.id()).orElseThrow(
                () -> new EntityNotFoundException("Warehouse with give id [" + warehouseId.id() + "] not found.")
        );
        return warehouseJpaEntity.toDomain();
    }
}
