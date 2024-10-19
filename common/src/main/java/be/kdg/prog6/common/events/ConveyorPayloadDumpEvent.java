package be.kdg.prog6.common.events;

import java.time.LocalDateTime;
import java.util.UUID;

public record ConveyorPayloadDumpEvent(UUID eventId, String timestamp, UUID warehouseId) {

}
