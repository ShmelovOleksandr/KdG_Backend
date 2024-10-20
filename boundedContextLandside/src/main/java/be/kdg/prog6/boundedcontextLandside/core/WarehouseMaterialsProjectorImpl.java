package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.*;
import be.kdg.prog6.boundedcontextLandside.port.in.WarehouseMaterialsProjector;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindWarehousePort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.PersistWarehousePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WarehouseMaterialsProjectorImpl implements WarehouseMaterialsProjector {
    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseMaterialsProjectorImpl.class);
    private final PersistWarehousePort persistWarehousePort;
    private final FindWarehousePort findWarehousePort;

    @Autowired
    public WarehouseMaterialsProjectorImpl(PersistWarehousePort persistWarehousePort, FindWarehousePort findWarehousePort) {
        this.persistWarehousePort = persistWarehousePort;
        this.findWarehousePort = findWarehousePort;
    }

    @Override
    public void projectWarehouse(WarehouseId warehouseId, WarehouseActivityType activityType, MaterialType materialType, BigDecimal tons) {
        Warehouse warehouse = findWarehousePort.findWarehouseById(warehouseId);
        warehouse.updateMaterials(activityType, new Material(materialType, tons));
        persistWarehousePort.save(warehouse);
        LOGGER.info("Warehouse {} updated. Current material: {}", warehouseId, warehouse.getCurrentlyStoredMaterial());
    }
}
