package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto;

import be.kdg.prog6.boundedcontextLandside.domain.*;
import be.kdg.prog6.boundedcontextLandside.port.in.ScheduleAppointmentCommand;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public record AppointmentPostDto(UUID sellerId, String truckLicensePlate, MaterialType deliveredMaterialType, LocalDate date, Integer preferredHour) {
    public AppointmentPostDto {
        Objects.requireNonNull(sellerId);
        Objects.requireNonNull(truckLicensePlate);
        Objects.requireNonNull(deliveredMaterialType);
        Objects.requireNonNull(date);
        Objects.requireNonNull(preferredHour);
    }

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
