package be.kdg.prog6.common.events;

import java.math.BigDecimal;
import java.util.UUID;

public record DeliveredMaterialWeightedEvent(UUID eventId, UUID appointmentId, BigDecimal deliveredWeight) {
}
