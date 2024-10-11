package be.kdg.prog6.boundedcontextWarehouse.core;

import be.kdg.prog6.boundedcontextWarehouse.domain.Material;
import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivity;
import be.kdg.prog6.boundedcontextWarehouse.port.in.ReceiveMaterialCommand;
import be.kdg.prog6.boundedcontextWarehouse.port.in.ReceiveMaterialUseCase;
import be.kdg.prog6.boundedcontextWarehouse.port.out.messaging.NotifyWarehouseUpdatePort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindWarehouseBySellerAndMaterialCommand;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindWarehousePort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.UpdateWarehousePort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReceiveMaterialUseCaseImpl implements ReceiveMaterialUseCase {
    private final FindWarehousePort findWarehouseForSellerAndMaterialPort;
    private final UpdateWarehousePort updateWarehousePort;
    private final NotifyWarehouseUpdatePort notifyWarehouseUpdatePort;


    public ReceiveMaterialUseCaseImpl(FindWarehousePort findWarehouseForSellerAndMaterialPort,
                                      UpdateWarehousePort updateWarehousePort,
                                      NotifyWarehouseUpdatePort notifyWarehouseUpdatePort) {
        this.findWarehouseForSellerAndMaterialPort = findWarehouseForSellerAndMaterialPort;
        this.updateWarehousePort = updateWarehousePort;
        this.notifyWarehouseUpdatePort = notifyWarehouseUpdatePort;
    }

    @Override
    @Transactional
    public void receiveMaterial(ReceiveMaterialCommand receiveMaterialCommand) {
        //find warehouse
        Material material = receiveMaterialCommand.material();
        FindWarehouseBySellerAndMaterialCommand findWarehouseBySellerAndMaterialCommand = new FindWarehouseBySellerAndMaterialCommand(receiveMaterialCommand.sellerId(), material.materialType());
        Warehouse warehouse = findWarehouseForSellerAndMaterialPort.findWarehouseBySellerAndMaterial(findWarehouseBySellerAndMaterialCommand);

        //add tons
        WarehouseActivity warehouseActivity = warehouse.addMaterial(material);

        //update
        updateWarehousePort.updateWarehouse(warehouse);

        //notify landside
        notifyWarehouseUpdatePort.notifyWarehouseUpdated(warehouse, warehouseActivity);
    }
}
