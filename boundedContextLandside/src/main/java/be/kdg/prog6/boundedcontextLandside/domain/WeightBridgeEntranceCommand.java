package be.kdg.prog6.boundedcontextLandside.domain;

import java.math.BigDecimal;

public record WeightBridgeEntranceCommand(AppointmentId appointmentId, BigDecimal weight) {
}
