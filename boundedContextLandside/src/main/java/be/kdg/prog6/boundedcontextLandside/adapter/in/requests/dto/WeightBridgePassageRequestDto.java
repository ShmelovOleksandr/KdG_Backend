package be.kdg.prog6.boundedcontextLandside.adapter.in.requests.dto;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgePassageCommand;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public record WeightBridgePassageRequestDto(UUID appointmentId, BigDecimal weight) {
    public WeightBridgePassageRequestDto {
        Objects.requireNonNull(appointmentId);
        Objects.requireNonNull(weight);
    }

    public WeightBridgePassageCommand toCommand() {
        return new WeightBridgePassageCommand(
                new AppointmentId(appointmentId),
                weight
        );
    }

}
