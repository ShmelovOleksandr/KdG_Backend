package be.kdg.prog6.boundedcontextLandside.port.in;

import be.kdg.prog6.boundedcontextLandside.domain.LicensePlate;
import be.kdg.prog6.boundedcontextLandside.domain.MaterialType;
import be.kdg.prog6.boundedcontextLandside.domain.ScheduleTime;
import be.kdg.prog6.boundedcontextLandside.domain.SellerId;

public record ScheduleAppointmentCommand(SellerId sellerId, LicensePlate truckLicensePlate, MaterialType materialType, ScheduleTime scheduleTime) {
}
