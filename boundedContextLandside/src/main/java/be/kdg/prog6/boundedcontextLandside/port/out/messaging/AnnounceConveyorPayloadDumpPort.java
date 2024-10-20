package be.kdg.prog6.boundedcontextLandside.port.out.messaging;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;

public interface AnnounceConveyorPayloadDumpPort {
    void announceConveyorPayloadDump(AppointmentId appointmentId, WarehouseId destinationWarehouseId);
}
