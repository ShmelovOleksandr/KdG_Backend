package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto;

import be.kdg.prog6.boundedcontextLandside.domain.*;

import java.time.LocalDate;
import java.util.UUID;

public record AppointmentGetDto(UUID appointmentId, UUID sellerId, String licensePlate, MaterialType materialType, LocalDate scheduledDate, int preferredHour) {
    public static AppointmentGetDto of(Appointment appointment) {
        return new AppointmentGetDto(
                appointment.getAppointmentId().id(),
                appointment.getSellerId().id(),
                appointment.getLicensePlate().licensePlateString(),
                appointment.getMaterialType(),
                appointment.getDate(),
                appointment.getArivalHour().hourNumber()
        );
    }
}
