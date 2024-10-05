package be.kdg.prog6.boundedcontextWarehouse.adapter.out;

import be.kdg.prog6.boundedcontextWarehouse.domain.MaterialType;
import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivityWindow;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindWarehouseBySellerAndMaterialCommand;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindWarehouseForSellerAndMaterialPort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.UpdateWarehousePort;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class WarehouseDatabaseAdapter implements FindWarehouseForSellerAndMaterialPort, UpdateWarehousePort {
    private final ModelMapper mapper;
    private final WarehouseJpaRepository warehouseJpaRepository;

    @Autowired
    public WarehouseDatabaseAdapter(ModelMapper mapper, WarehouseJpaRepository warehouseJpaRepository) {
        this.mapper = mapper;
        this.warehouseJpaRepository = warehouseJpaRepository;
    }

    @Override
    public Warehouse findWarehouseBySellerAndMaterial(FindWarehouseBySellerAndMaterialCommand findWarehouseBySellerAndMaterialCommand) {
        UUID sellerId = findWarehouseBySellerAndMaterialCommand.sellerId().id();
        MaterialType materialTypeStored = findWarehouseBySellerAndMaterialCommand.materialType();
        WarehouseJpaEntity warehouseJpaEntity = warehouseJpaRepository.findAllBySeller_IdAndMaterialTypeStored(sellerId, materialTypeStored).orElseThrow(
                () -> new EntityNotFoundException("Warehouse with given SellerId[%s] and MaterialType[%s] was not found.".formatted(sellerId, materialTypeStored))
        );
        return mapper.map(warehouseJpaEntity, Warehouse.class);
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) {
        WarehouseJpaEntity warehouseJpaEntity = mapper.map(warehouse, WarehouseJpaEntity.class);
        warehouseJpaRepository.save(warehouseJpaEntity);
    }
}
