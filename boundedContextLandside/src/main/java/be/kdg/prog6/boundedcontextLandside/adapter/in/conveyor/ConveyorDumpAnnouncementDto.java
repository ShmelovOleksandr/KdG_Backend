package be.kdg.prog6.boundedcontextLandside.adapter.in.conveyor;

import java.util.Objects;
import java.util.UUID;

public record ConveyorDumpAnnouncementDto(UUID appointmentId, UUID warehouseId) {
    public ConveyorDumpAnnouncementDto {
        Objects.requireNonNull(appointmentId);
        Objects.requireNonNull(warehouseId);
    }
}
