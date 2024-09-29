package be.kdg.prog6.boundedcontextWarehouse.adapter.out;

import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindWarehouseBySellerAndMaterialCommand;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindWarehouseForSellerAndMaterialPort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.UpdateWarehousePort;
import org.springframework.stereotype.Component;

@Component
public class WarehouseDatabaseAdapter implements FindWarehouseForSellerAndMaterialPort, UpdateWarehousePort {
    @Override
    public Warehouse findWarehouseBySellerAndMaterial(FindWarehouseBySellerAndMaterialCommand findWarehouseBySellerAndMaterialCommand) {
        return null;
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) {

    }
}
