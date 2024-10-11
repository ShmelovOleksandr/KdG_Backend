package be.kdg.prog6.boundedcontextLandside.adapter.in.appointment.dto;

import be.kdg.prog6.boundedcontextLandside.domain.*;

import java.util.UUID;

public record AppointmentPostDto(UUID sellerId, String truckLicensePlate, MaterialType deliveredMaterialType, int preferredHour) {
    public Appointment toAppointment() {
        return new Appointment(
                null,
                new SellerId(sellerId),
                new LicensePlate(truckLicensePlate),
                deliveredMaterialType,
                new Hour(preferredHour)
        );
    }
}
