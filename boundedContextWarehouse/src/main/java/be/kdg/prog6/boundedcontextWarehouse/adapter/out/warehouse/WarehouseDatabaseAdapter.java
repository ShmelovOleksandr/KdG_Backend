package be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse;

import be.kdg.prog6.boundedcontextWarehouse.adapter.out.warehouse.exception.WarehouseNotFoundException;
import be.kdg.prog6.boundedcontextWarehouse.domain.*;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindWarehouseBySellerAndMaterialCommand;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindWarehousePort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.PersistWarehousePort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class WarehouseDatabaseAdapter implements FindWarehousePort, PersistWarehousePort {
    private final WarehouseJpaRepository warehouseJpaRepository;
    private final WarehouseActivityWindowJpaRepository warehouseActivityWindowJpaRepository;
    private final WarehouseActivityJpaRepository warehouseActivityJpaRepository;

    @Autowired
    public WarehouseDatabaseAdapter(WarehouseJpaRepository warehouseJpaRepository, WarehouseActivityWindowJpaRepository warehouseActivityWindowJpaRepository, WarehouseActivityJpaRepository warehouseActivityJpaRepository) {
        this.warehouseJpaRepository = warehouseJpaRepository;
        this.warehouseActivityWindowJpaRepository = warehouseActivityWindowJpaRepository;
        this.warehouseActivityJpaRepository = warehouseActivityJpaRepository;
    }


    //TODO This implementation works but it's shitty
    @Override
    public Warehouse findWarehouseById(WarehouseId warehouseId) {
        Warehouse warehouse = warehouseJpaRepository.findByIdFetched(warehouseId.id()).orElseThrow(
                () -> new WarehouseNotFoundException("Warehouse with given id [%s] not found.".formatted(warehouseId.id()))
        ).toDomain();

        List<WarehouseActivity> warehouseActivities = warehouseActivityJpaRepository.findAllByWarehouseId(warehouseId.id()).stream().map(WarehouseActivityJpaEntity::toDomain).toList();
        warehouse.getWarehouseActivityWindow().setActivities(new ArrayList<>(warehouseActivities));
        return warehouse;
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
    public Warehouse save(Warehouse warehouse) {
        WarehouseActivityWindow warehouseActivityWindow = warehouse.getWarehouseActivityWindow();
        List<WarehouseActivity> warehouseActivities = warehouseActivityWindow.getActivities();

        WarehouseActivityWindowJpaEntity warehouseActivityWindowJpaEntity = WarehouseActivityWindowJpaEntity.of(warehouseActivityWindow);
        warehouseActivityWindowJpaEntity.setActivities(null);
        warehouseActivityWindowJpaRepository.save(warehouseActivityWindowJpaEntity);
        List<WarehouseActivityJpaEntity> warehouseActivityJpaEntities = warehouseActivities.stream().map(WarehouseActivityJpaEntity::of).toList();
        warehouseActivityJpaEntities.forEach(warehouseActivityJpaEntity -> warehouseActivityJpaEntity.setWarehouseActivityWindow(warehouseActivityWindowJpaEntity));
        warehouseActivityJpaRepository.saveAll(warehouseActivityJpaEntities);

        WarehouseJpaEntity warehouseJpaEntity = WarehouseJpaEntity.of(warehouse);
        return warehouseJpaRepository.save(warehouseJpaEntity).toDomain();
    }
}
