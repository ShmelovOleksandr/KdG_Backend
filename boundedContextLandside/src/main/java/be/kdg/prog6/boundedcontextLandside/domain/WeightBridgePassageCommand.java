package be.kdg.prog6.boundedcontextLandside.domain;

import java.math.BigDecimal;

public record WeightBridgePassageCommand(AppointmentId appointmentId, BigDecimal weight) {
}
