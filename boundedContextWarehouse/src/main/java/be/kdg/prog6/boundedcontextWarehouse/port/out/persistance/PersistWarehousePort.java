package be.kdg.prog6.boundedcontextWarehouse.port.out.persistance;

import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;

public interface PersistWarehousePort {
    Warehouse save(Warehouse warehouse);
}
