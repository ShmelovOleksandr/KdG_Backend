package be.kdg.prog6.boundedcontextLandside.port.in;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.domain.WarehouseId;

public interface DumpPayloadUseCase {
    void handlePayloadDelivery(AppointmentId appointmentId, WarehouseId warehouseId);
}
