package be.kdg.prog6.boundedcontextLandside.port.in;

import be.kdg.prog6.boundedcontextLandside.domain.*;

public record ScheduleAppointmentCommand(SellerId sellerId, LicensePlate truckLicensePlate, MaterialType materialType, Hour prefferedHour) {
}
