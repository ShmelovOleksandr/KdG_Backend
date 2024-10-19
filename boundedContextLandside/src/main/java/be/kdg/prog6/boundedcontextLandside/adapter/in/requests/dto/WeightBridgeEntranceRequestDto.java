package be.kdg.prog6.boundedcontextLandside.adapter.in.requests.dto;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.domain.WeightBridgeEntranceCommand;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public record WeightBridgeEntranceRequestDto(UUID appointmentId, BigDecimal weight) {
    public WeightBridgeEntranceRequestDto {
        Objects.requireNonNull(appointmentId);
        Objects.requireNonNull(weight);
    }

    public WeightBridgeEntranceCommand toCommand() {
        return new WeightBridgeEntranceCommand(
                new AppointmentId(appointmentId),
                weight
        );
    }

}
