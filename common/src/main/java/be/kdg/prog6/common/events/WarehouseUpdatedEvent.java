package be.kdg.prog6.common.events;

 import java.math.BigDecimal;
import java.util.UUID;


public record WarehouseUpdatedEvent(UUID warehouseEventId, UUID warehouseId, String activityType, String materialType, BigDecimal tons) {
}
