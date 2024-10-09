package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto;

import be.kdg.prog6.boundedcontextLandside.domain.*;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentPostDto(UUID sellerId, String truckLicensePlate, MaterialType deliveredMaterialType, LocalDateTime appointmentTime) {
    public Appointment toAppointment() {
        return new Appointment(
                null,
                new SellerId(sellerId),
                new LicensePlate(truckLicensePlate),
                deliveredMaterialType,
                new ScheduleTime(appointmentTime)
        );
    }
}
