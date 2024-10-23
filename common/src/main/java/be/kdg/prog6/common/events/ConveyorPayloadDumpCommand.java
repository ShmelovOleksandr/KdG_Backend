package be.kdg.prog6.common.events;

import java.util.UUID;

public record ConveyorPayloadDumpCommand(UUID eventId, String timestampString, UUID appointmentId, UUID warehouseId) {

}
