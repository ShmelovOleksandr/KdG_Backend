package be.kdg.prog6.common.events;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record WeightingBridgePassageEvent(UUID eventId, LocalDateTime time, UUID warehouseId, Type eventType, BigDecimal truckWeight) {

    public enum Type {
        ENTRANCE, EXIT
    }
}
