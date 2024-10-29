package be.kdg.prog6.boundedcontextWaterside.core;

import be.kdg.prog6.boundedcontextWaterside.domain.*;
import be.kdg.prog6.boundedcontextWaterside.port.in.ShipDepartureUseCase;
import be.kdg.prog6.boundedcontextWaterside.port.out.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShipDepartureUseCaseImpl implements ShipDepartureUseCase {
    private final FindSOPort findSOPort;
    private final FindPOPort findPOPort;
    private final FindWarehousePort findWarehousePort;
    private final NotifyWarehouseUpdatePort warehouseUpdatePort;

    @Autowired
    public ShipDepartureUseCaseImpl(FindSOPort findSOPort, FindPOPort findPOPort, FindWarehousePort findWarehousePort, NotifyWarehouseUpdatePort warehouseUpdatePort) {
        this.findSOPort = findSOPort;
        this.findPOPort = findPOPort;
        this.findWarehousePort = findWarehousePort;
        this.warehouseUpdatePort = warehouseUpdatePort;
    }

    @Override
    @Transactional
    public void manageShipDeparture(SOId soId) {
        SO so = findSOPort.findSOById(soId);
        so.validateAllInspections();

        PO po = findPOPort.findPOById(so.getPurchaseOrderId());
        List<OrderItem> orderLines = po.getOrderLines();
        SellerId sellerId = po.getSeller().sellerId();
        for (OrderItem orderItem : orderLines) {
            Warehouse warehouse = findWarehousePort.findWarehouseBySellerAndMaterial(new FindWarehouseBySellerAndMaterialCommand(sellerId, orderItem.materialType()));
            warehouseUpdatePort.notifyWarehouseMaterialDecreased(warehouse.getWarehouseId(), orderItem);
        }
    }
}
