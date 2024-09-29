package be.kdg.prog6.boundedcontextWarehouse.core;

import be.kdg.prog6.boundedcontextWarehouse.domain.Material;
import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;
import be.kdg.prog6.boundedcontextWarehouse.port.in.ReceiveMaterialCommand;
import be.kdg.prog6.boundedcontextWarehouse.port.in.ReceiveMaterialUseCase;
import be.kdg.prog6.boundedcontextWarehouse.port.out.FindWarehouseBySellerAndMaterialCommand;
import be.kdg.prog6.boundedcontextWarehouse.port.out.FindWarehouseForSellerAndMaterialPort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.UpdateWarehousePort;
import org.springframework.stereotype.Service;

@Service
public class ReceiveMaterialUseCaseImpl implements ReceiveMaterialUseCase {
    private final FindWarehouseForSellerAndMaterialPort findWarehouseForSellerAndMaterialPort;
    private final UpdateWarehousePort updateWarehousePort;


    public ReceiveMaterialUseCaseImpl(FindWarehouseForSellerAndMaterialPort findWarehouseForSellerAndMaterialPort, UpdateWarehousePort updateWarehousePort) {
        this.findWarehouseForSellerAndMaterialPort = findWarehouseForSellerAndMaterialPort;
        this.updateWarehousePort = updateWarehousePort;
    }

    @Override
    public void receiveMaterial(ReceiveMaterialCommand receiveMaterialCommand) {
        //find warehouse
        Material material = receiveMaterialCommand.material();
        FindWarehouseBySellerAndMaterialCommand findWarehouseBySellerAndMaterialCommand = new FindWarehouseBySellerAndMaterialCommand(receiveMaterialCommand.sellerId(), material.materialType());
        Warehouse warehouse = findWarehouseForSellerAndMaterialPort.findWarehouseBySellerAndMaterial(findWarehouseBySellerAndMaterialCommand);

        //add tons
        warehouse.addMaterial(material);

        //update
        updateWarehousePort.updateWarehouse(warehouse);

        // TODO
        //  Notify landside?

    }
}
