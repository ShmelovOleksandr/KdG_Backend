package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.Material;
import be.kdg.prog6.boundedcontextLandside.domain.Warehouse;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseActivityType;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;
import be.kdg.prog6.boundedcontextLandside.port.in.WarehouseMaterialsProjector;
import be.kdg.prog6.boundedcontextLandside.port.out.FindWarehousePort;
import be.kdg.prog6.boundedcontextLandside.port.out.WarehouseUpdatePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseMaterialsProjectorImpl implements WarehouseMaterialsProjector {
    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseMaterialsProjectorImpl.class);
    private final WarehouseUpdatePort warehouseUpdatePort;
    private final FindWarehousePort findWarehousePort;

    @Autowired
    public WarehouseMaterialsProjectorImpl(WarehouseUpdatePort warehouseUpdatePort, FindWarehousePort findWarehousePort) {
        this.warehouseUpdatePort = warehouseUpdatePort;
        this.findWarehousePort = findWarehousePort;
    }

    @Override
    public void projectMaterials(WarehouseId warehouseId, WarehouseActivityType activityType, Material material) {
        Warehouse warehouse = findWarehousePort.findWarehouseById(warehouseId);
        warehouse.updateMaterials(activityType, material);
        warehouseUpdatePort.updateWarehouse(warehouse);
        LOGGER.info("Warehouse {} updated. Current material: {}", warehouseId, warehouse.getCurrentlyStoredMaterial());
    }
}
