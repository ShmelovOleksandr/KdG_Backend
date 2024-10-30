package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto;

import be.kdg.prog6.boundedcontextLandside.domain.*;

import java.time.LocalDate;
import java.util.UUID;

public record AppointmentGetDto(UUID appointmentId, UUID sellerId, String licensePlate, MaterialType materialType, LocalDate scheduledDate, int preferredHour, AppointmentStatus status) {
    public static AppointmentGetDto of(Appointment appointment) {
        AppointmentStatus status;
        if (appointment.getEntranceTime() != null && appointment.getDepartureTime() == null)
            status = AppointmentStatus.ARRIVED;
        else if (appointment.getEntranceTime() != null && appointment.getDepartureTime() != null)
            status = AppointmentStatus.DEPARTED;
        else
            status = AppointmentStatus.PLANNED;

        return new AppointmentGetDto(
                appointment.getAppointmentId().id(),
                appointment.getSellerId().id(),
                appointment.getLicensePlate().licensePlateString(),
                appointment.getMaterialType(),
                appointment.getDate(),
                appointment.getArrivalHour().hourNumber(),
                status
        );
    }

    private enum AppointmentStatus {
        PLANNED, ARRIVED, DEPARTED
    }
}
