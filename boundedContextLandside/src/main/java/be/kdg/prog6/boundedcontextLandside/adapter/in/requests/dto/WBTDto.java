package be.kdg.prog6.boundedcontextLandside.adapter.in.requests.dto;

import be.kdg.prog6.boundedcontextLandside.domain.WBT;

import java.math.BigDecimal;
import java.util.UUID;

public record WBTDto(UUID wbtId, UUID appointmentId, BigDecimal entranceWeight, BigDecimal exitWeight, BigDecimal deliveredWeight) {
    public static WBTDto of(WBT wbt) {
        return new WBTDto(
                wbt.getWbtId().id(),
                wbt.getAppointmentId().id(),
                wbt.getEntranceWeight(),
                wbt.getExitWeight(),
                wbt.getWeightDifferance()
        );
    }
}
