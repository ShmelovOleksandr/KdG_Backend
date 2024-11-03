package be.kdg.prog6.boundedcontextWaterside.core;

import be.kdg.prog6.boundedcontextWaterside.domain.*;
import be.kdg.prog6.boundedcontextWaterside.port.out.PersistPOPort;
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
    private final PersistSOPort persistSOPort;
    private final PersistPOPort persistPOPort;

    @Autowired
    public ShipDepartureUseCaseImpl(FindSOPort findSOPort, FindPOPort findPOPort, FindWarehousePort findWarehousePort, NotifyWarehouseUpdatePort warehouseUpdatePort, PersistSOPort persistSOPort, PersistPOPort persistPOPort) {
        this.findSOPort = findSOPort;
        this.findPOPort = findPOPort;
        this.findWarehousePort = findWarehousePort;
        this.warehouseUpdatePort = warehouseUpdatePort;
        this.persistSOPort = persistSOPort;
        this.persistPOPort = persistPOPort;
    }

    @Override
    @Transactional
    public void manageShipDeparture(SOId soId) {
        SO so = findSOPort.findSOById(soId);
        so.handleShipDeparture();

        PO po = findPOPort.findPOById(so.getPurchaseOrderId());
        po.setRespectiveSO(so);

        List<OrderItem> orderLines = po.getOrderLines();
        SellerId sellerId = po.getSeller().sellerId();
        for (OrderItem orderItem : orderLines) {
            Warehouse warehouse = findWarehousePort.findWarehouseBySellerAndMaterial(new FindWarehouseBySellerAndMaterialCommand(sellerId, orderItem.materialType()));
            warehouseUpdatePort.notifyWarehouseMaterialDecreased(warehouse.getWarehouseId(), orderItem);
        }

        persistSOPort.save(so);
        persistPOPort.save(po);
    }
}
