package be.kdg.prog6.boundedcontextLandside.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PDT(PDTId id, LocalDateTime arrivalTime, MaterialType materialType, BigDecimal initialTruckWeight, BigDecimal exitTruckWeight) {
}
