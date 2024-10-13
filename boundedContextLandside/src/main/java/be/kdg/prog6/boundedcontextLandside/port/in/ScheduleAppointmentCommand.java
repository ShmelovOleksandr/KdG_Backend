package be.kdg.prog6.boundedcontextLandside.port.in;

import be.kdg.prog6.boundedcontextLandside.domain.*;

import java.time.LocalDate;

public record ScheduleAppointmentCommand(SellerId sellerId, LicensePlate truckLicensePlate, MaterialType materialType, LocalDate date, Hour prefferedHour) {
}
