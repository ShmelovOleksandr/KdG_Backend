package be.kdg.prog6.boundedcontextWaterside.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextWaterside.adapter.out.exception.WarehouseNotFoundException;
import be.kdg.prog6.boundedcontextWaterside.domain.MaterialType;
import be.kdg.prog6.boundedcontextWaterside.domain.Warehouse;
import be.kdg.prog6.boundedcontextWaterside.port.out.FindWarehouseBySellerAndMaterialCommand;
import be.kdg.prog6.boundedcontextWaterside.port.out.FindWarehousePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class WarehouseDatabaseAdapter implements FindWarehousePort {
    private final WarehouseJpaRepository warehouseJpaRepository;

    @Autowired
    public WarehouseDatabaseAdapter(WarehouseJpaRepository warehouseJpaRepository) {
        this.warehouseJpaRepository = warehouseJpaRepository;
    }

    @Override
    public Warehouse findWarehouseBySellerAndMaterial(FindWarehouseBySellerAndMaterialCommand findWarehouseBySellerAndMaterialCommand) {
        UUID ownerId = findWarehouseBySellerAndMaterialCommand.sellerId().id();
        MaterialType materialType = findWarehouseBySellerAndMaterialCommand.materialType();
        return warehouseJpaRepository.findByOwner_SellerIdAndMaterialType(ownerId, materialType).orElseThrow(
                () -> new WarehouseNotFoundException("Warehouse with given OwnerId[%s] and MaterialType[%s] not found".formatted(ownerId, materialType))
        ).toDomain();
    }
}
