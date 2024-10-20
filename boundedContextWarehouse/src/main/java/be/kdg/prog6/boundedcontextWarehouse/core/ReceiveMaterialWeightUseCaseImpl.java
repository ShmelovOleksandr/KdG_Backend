package be.kdg.prog6.boundedcontextWarehouse.core;

import be.kdg.prog6.boundedcontextWarehouse.domain.PDT;
import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseActivity;
import be.kdg.prog6.boundedcontextWarehouse.port.in.ReceiveMaterialWeightCommand;
import be.kdg.prog6.boundedcontextWarehouse.port.in.ReceiveMaterialWeightUseCase;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindPDTPort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.messaging.NotifyWarehouseUpdatePort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindWarehousePort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.PersistPDTPort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.PersistWarehousePort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReceiveMaterialWeightUseCaseImpl implements ReceiveMaterialWeightUseCase {
    private final FindWarehousePort findWarehouseForSellerAndMaterialPort;
    private final PersistWarehousePort persistWarehousePort;
    private final NotifyWarehouseUpdatePort notifyWarehouseUpdatePort;

    private final FindPDTPort findPDTPort;
    private final PersistPDTPort persistPDTPort;


    public ReceiveMaterialWeightUseCaseImpl(FindWarehousePort findWarehouseForSellerAndMaterialPort,
                                            PersistWarehousePort persistWarehousePort,
                                            NotifyWarehouseUpdatePort notifyWarehouseUpdatePort,
                                            FindPDTPort findPDTPort,
                                            PersistPDTPort persistPDTPort) {
        this.findWarehouseForSellerAndMaterialPort = findWarehouseForSellerAndMaterialPort;
        this.persistWarehousePort = persistWarehousePort;
        this.notifyWarehouseUpdatePort = notifyWarehouseUpdatePort;
        this.findPDTPort = findPDTPort;
        this.persistPDTPort = persistPDTPort;
    }

    @Override
    @Transactional
    public void receiveMaterialWeight(ReceiveMaterialWeightCommand receiveMaterialWeightCommand) {
        PDT pdt = findPDTPort.findPDTByAppointmentId(receiveMaterialWeightCommand.appointmentId());
        pdt.enrich(receiveMaterialWeightCommand.weight());
        PDT savedPdt = persistPDTPort.save(pdt);

        Warehouse warehouse = findWarehouseForSellerAndMaterialPort.findWarehouseById(savedPdt.getWarehouseId());
        WarehouseActivity warehouseActivity = warehouse.addMaterialTons(savedPdt.getDeliveredWeigh());
        Warehouse savedWarehouse = persistWarehousePort.save(warehouse);

        notifyWarehouseUpdatePort.notifyWarehouseUpdated(savedWarehouse, warehouseActivity);
    }
}
