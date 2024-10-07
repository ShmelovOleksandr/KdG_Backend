package be.kdg.prog6.boundedcontextLandside.adapter.out;

import be.kdg.prog6.boundedcontextLandside.domain.Warehouse;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;
import be.kdg.prog6.boundedcontextLandside.port.out.FindWarehousePort;
import be.kdg.prog6.boundedcontextLandside.port.out.WarehouseUpdatePort;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WarehouseDatabaseAdapter implements FindWarehousePort, WarehouseUpdatePort  {
    private final ModelMapper mapper;
    private final WarehouseJpaRepository warehouseJpaRepository;

    @Autowired
    public WarehouseDatabaseAdapter(ModelMapper mapper, WarehouseJpaRepository warehouseJpaRepository) {
        this.mapper = mapper;
        this.warehouseJpaRepository = warehouseJpaRepository;
    }


    @Override
    public void updateWarehouse(Warehouse warehouse) {
        WarehouseJpaEntity warehouseJpaEntity = mapper.map(warehouse, WarehouseJpaEntity.class);
        warehouseJpaRepository.save(warehouseJpaEntity);
    }

    @Override
    public Warehouse findWarehouseById(WarehouseId warehouseId) {
        WarehouseJpaEntity warehouseJpaEntity = warehouseJpaRepository.findByIdWithOwnerFetched(warehouseId.id()).orElseThrow(
                () -> new EntityNotFoundException("Warehouse with give id [" + warehouseId.id() + "] not found.")
        );
        return mapper.map(warehouseJpaEntity, Warehouse.class);
    }
}
