package be.kdg.prog6.boundedcontextWarehouse.core;

import be.kdg.prog6.boundedcontextWarehouse.domain.AppointmentId;
import be.kdg.prog6.boundedcontextWarehouse.domain.PDT;
import be.kdg.prog6.boundedcontextWarehouse.domain.Warehouse;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseId;
import be.kdg.prog6.boundedcontextWarehouse.port.in.HandleConveyorPayloadDumpPort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.PersistPDTPort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindWarehousePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ConveyorPayloadDumpHandler implements HandleConveyorPayloadDumpPort {
    private final FindWarehousePort findWarehousePort;
    private final PersistPDTPort persistPDTPort;

    public ConveyorPayloadDumpHandler(FindWarehousePort findWarehousePort, PersistPDTPort persistPDTPort) {
        this.findWarehousePort = findWarehousePort;
        this.persistPDTPort = persistPDTPort;
    }

    @Override
    @Transactional
    public void handleConveyorPayloadDump(AppointmentId appointmentId, LocalDateTime timestamp, WarehouseId destinationWarehouseId) {
        Warehouse warehouse = findWarehousePort.findWarehouseById(destinationWarehouseId);

        PDT pdt = warehouse.generatePDT(appointmentId, timestamp);

        persistPDTPort.save(pdt);
    }
}
