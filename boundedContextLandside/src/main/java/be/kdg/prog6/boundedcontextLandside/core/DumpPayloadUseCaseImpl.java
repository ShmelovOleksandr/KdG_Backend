package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;
import be.kdg.prog6.boundedcontextLandside.port.in.DumpPayloadUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.AnnounceConveyorPayloadDumpPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DumpPayloadUseCaseImpl implements DumpPayloadUseCase {
    private final AnnounceConveyorPayloadDumpPort announceConveyorPayloadDumpPort;

    @Autowired
    public DumpPayloadUseCaseImpl(AnnounceConveyorPayloadDumpPort announceConveyorPayloadDumpPort) {
        this.announceConveyorPayloadDumpPort = announceConveyorPayloadDumpPort;
    }

    @Override
    public void handlePayloadDelivery(AppointmentId appointmentId, WarehouseId warehouseId) {
        announceConveyorPayloadDumpPort.announceConveyorPayloadDump(appointmentId, warehouseId);
    }
}
