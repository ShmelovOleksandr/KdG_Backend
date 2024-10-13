package be.kdg.prog6.boundedcontextLandside.domain;

import java.time.LocalDate;
import java.util.Objects;

public record Appointment(AppointmentId appointmentId, SellerId sellerId, LicensePlate licensePlate, MaterialType materialType, LocalDate date, Hour preferredHour) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(date, that.date) && Objects.equals(sellerId, that.sellerId) && Objects.equals(preferredHour, that.preferredHour) && Objects.equals(licensePlate, that.licensePlate) && materialType == that.materialType && Objects.equals(appointmentId, that.appointmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, sellerId, licensePlate, materialType, date, preferredHour);
    }
}
