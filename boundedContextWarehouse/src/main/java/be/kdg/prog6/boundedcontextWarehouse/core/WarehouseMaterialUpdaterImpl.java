package be.kdg.prog6.boundedcontextWarehouse.core;

import be.kdg.prog6.boundedcontextWarehouse.domain.*;
import be.kdg.prog6.boundedcontextWarehouse.port.in.WarehouseMaterialsUpdater;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindWarehousePort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.PersistWarehousePort;
import jakarta.persistence.Column;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class WarehouseMaterialUpdaterImpl implements WarehouseMaterialsUpdater {
    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseMaterialUpdaterImpl.class);
    private final PersistWarehousePort persistWarehousePort;
    private final FindWarehousePort findWarehousePort;

    @Autowired
    public WarehouseMaterialUpdaterImpl(PersistWarehousePort persistWarehousePort, FindWarehousePort findWarehousePort) {
        this.persistWarehousePort = persistWarehousePort;
        this.findWarehousePort = findWarehousePort;
    }

    @Override
    @Transactional
    public void updateWarehouse(WarehouseId warehouseId, WarehouseActivityType activityType, MaterialType materialType, BigDecimal tons) {
        Warehouse warehouse = findWarehousePort.findWarehouseById(warehouseId);
        warehouse.removeMaterialTons(tons);
        persistWarehousePort.save(warehouse);
        LOGGER.info("Warehouse {} updated. Current material: {}", warehouseId, warehouse.getMaterialTypeStored());
    }
}
