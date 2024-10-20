package be.kdg.prog6.boundedcontextLandside.port.out.messaging;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;

import java.math.BigDecimal;

public interface TransferDeliveredWeightPort {
    void publishDeliveredWeight(AppointmentId appointmentId, BigDecimal weight);
}
