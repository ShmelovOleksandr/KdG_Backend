package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto;

import be.kdg.prog6.boundedcontextLandside.domain.*;

import java.util.UUID;

public record AppointmentGetDto(UUID appointmentId, UUID sellerId, String licensePlate, MaterialType materialType, int preferredHour) {
    public static AppointmentGetDto of(Appointment appointment) {
        return new AppointmentGetDto(
                appointment.appointmentId().id(),
                appointment.sellerId().id(),
                appointment.licensePlate().licensePlateString(),
                appointment.materialType(),
                appointment.preferredHour().hourNumber()
        );
    }
}
