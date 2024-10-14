package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto;

import be.kdg.prog6.boundedcontextLandside.domain.*;
import be.kdg.prog6.boundedcontextLandside.port.in.ScheduleAppointmentCommand;

import java.time.LocalDate;
import java.util.UUID;

public record AppointmentPostDto(UUID sellerId, String truckLicensePlate, MaterialType deliveredMaterialType, LocalDate date, int preferredHour) {
    public ScheduleAppointmentCommand toScheduleAppointmentCommand() {
        return new ScheduleAppointmentCommand(
                new SellerId(sellerId),
                new LicensePlate(truckLicensePlate),
                deliveredMaterialType,
                date,
                new Hour(preferredHour)
        );
    }
}
