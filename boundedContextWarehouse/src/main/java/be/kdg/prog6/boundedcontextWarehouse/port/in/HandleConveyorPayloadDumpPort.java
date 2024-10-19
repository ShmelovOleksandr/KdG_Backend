package be.kdg.prog6.boundedcontextWarehouse.port.in;

import be.kdg.prog6.boundedcontextWarehouse.domain.AppointmentId;
import be.kdg.prog6.boundedcontextWarehouse.domain.WarehouseId;

import java.time.LocalDateTime;

public interface HandleConveyorPayloadDumpPort {
    void handleConveyorPayloadDump(AppointmentId appointmentId, LocalDateTime timestamp, WarehouseId destinationWarehouseId);
}
