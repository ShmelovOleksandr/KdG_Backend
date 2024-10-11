package be.kdg.prog6.boundedcontextLandside.domain;

public record Appointment(AppointmentId appointmentId, SellerId sellerId, LicensePlate licensePlate, MaterialType materialType, Hour prefferredHour) {
}
