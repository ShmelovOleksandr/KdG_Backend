package be.kdg.prog6.boundedcontextLandside.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextLandside.domain.MaterialType;
import be.kdg.prog6.boundedcontextLandside.domain.SellerId;
import be.kdg.prog6.boundedcontextLandside.domain.Warehouse;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindWarehousePort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.PersistWarehousePort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersistWarehouseDatabaseAdapter implements FindWarehousePort, PersistWarehousePort {
    private final WarehouseJpaRepository warehouseJpaRepository;

    @Autowired
    public PersistWarehouseDatabaseAdapter(WarehouseJpaRepository warehouseJpaRepository) {
        this.warehouseJpaRepository = warehouseJpaRepository;
    }


    @Override
    public Warehouse save(Warehouse warehouse) {
        WarehouseJpaEntity warehouseJpaEntity = WarehouseJpaEntity.of(warehouse);
        return warehouseJpaRepository.save(warehouseJpaEntity).toDomain();
    }

    @Override
    public Warehouse findWarehouseById(WarehouseId warehouseId) {
        WarehouseJpaEntity warehouseJpaEntity = warehouseJpaRepository.findByIdWithOwnerFetched(warehouseId.id()).orElseThrow(
                () -> new EntityNotFoundException("Warehouse with give wbtId [" + warehouseId.id() + "] not found.")
        );
        return warehouseJpaEntity.toDomain();
    }

    @Override
    public Warehouse findWarehouseBySellerIdAndMaterialTypeStored(SellerId sellerId, MaterialType materialTypeStored) {
        WarehouseJpaEntity warehouseJpaEntity = warehouseJpaRepository.findBySellerIdAndMaterialTypeStored(sellerId.id(), materialTypeStored).orElseThrow(
                () -> new EntityNotFoundException("Warehouse with give SellerId [%s] and MaterialType [%s] not found.".formatted(sellerId.id(), materialTypeStored.name()))
        );
        return warehouseJpaEntity.toDomain();
    }
}
