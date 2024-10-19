package be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse.exception.WarehouseNotFoundException;
import be.kdg.prog6.boundedcontextWarehouse.domain.MaterialType;
import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseId;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindWarehouseBySellerAndMaterialCommand;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindWarehousePort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.UpdateWarehousePort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class WarehouseDatabaseAdapter implements FindWarehousePort, UpdateWarehousePort {
    private final WarehouseJpaRepository warehouseJpaRepository;

    @Autowired
    public WarehouseDatabaseAdapter(WarehouseJpaRepository warehouseJpaRepository) {
        this.warehouseJpaRepository = warehouseJpaRepository;
    }

    @Override
    public Warehouse findWarehouseById(WarehouseId warehouseId) {
        return warehouseJpaRepository.findById(warehouseId.id()).orElseThrow(
                () -> new WarehouseNotFoundException("Warehouse with given id [%s] not found.".formatted(warehouseId.id()))
        ).toDomain();
    }

    @Override
    public Warehouse findWarehouseBySellerAndMaterial(FindWarehouseBySellerAndMaterialCommand findWarehouseBySellerAndMaterialCommand) {
        UUID sellerId = findWarehouseBySellerAndMaterialCommand.sellerId().id();
        MaterialType materialTypeStored = findWarehouseBySellerAndMaterialCommand.materialType();
        WarehouseJpaEntity warehouseJpaEntity = warehouseJpaRepository.findAllBySeller_IdAndMaterialTypeStored(sellerId, materialTypeStored).orElseThrow(
                () -> new EntityNotFoundException("Warehouse with given SellerId[%s] and MaterialType[%s] was not found.".formatted(sellerId, materialTypeStored))
        );
        return warehouseJpaEntity.toDomain();
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) {
        WarehouseJpaEntity warehouseJpaEntity = WarehouseJpaEntity.of(warehouse);
        warehouseJpaRepository.save(warehouseJpaEntity);
    }
}
