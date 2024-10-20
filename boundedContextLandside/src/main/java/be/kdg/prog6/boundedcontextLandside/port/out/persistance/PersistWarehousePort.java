package be.kdg.prog6.boundedcontextLandside.port.out.persistance;

import be.kdg.prog6.boundedcontextLandside.domain.Warehouse;

public interface PersistWarehousePort {
    Warehouse save(Warehouse warehouse);
}
