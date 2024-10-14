package be.kdg.prog6.boundedcontextLandside.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment {

    private AppointmentId appointmentId;
    private SellerId sellerId;
    private LicensePlate licensePlate;
    private MaterialType materialType;
    private LocalDate date;
    private Hour arrivalHour;
    private LocalDateTime entranceTime;
    private LocalDateTime departureTime;

    public Appointment() {
    }

    public Appointment(AppointmentId appointmentId, SellerId sellerId, LicensePlate licensePlate, MaterialType materialType, LocalDate date, Hour arrivalHour) {
        this.appointmentId = appointmentId;
        this.sellerId = sellerId;
        this.licensePlate = licensePlate;
        this.materialType = materialType;
        this.date = date;
        this.arrivalHour = arrivalHour;
    }

    public Appointment(AppointmentId appointmentId, SellerId sellerId, LicensePlate licensePlate, MaterialType materialType, LocalDate date, Hour arrivalHour, LocalDateTime entranceTime, LocalDateTime departureTime) {
        this.appointmentId = appointmentId;
        this.sellerId = sellerId;
        this.licensePlate = licensePlate;
        this.materialType = materialType;
        this.date = date;
        this.arrivalHour = arrivalHour;
        this.entranceTime = entranceTime;
        this.departureTime = departureTime;
    }

    public AppointmentId getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(AppointmentId appointmentId) {
        this.appointmentId = appointmentId;
    }

    public SellerId getSellerId() {
        return sellerId;
    }

    public void setSellerId(SellerId sellerId) {
        this.sellerId = sellerId;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Hour getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(Hour arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public LocalDateTime getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(LocalDateTime entranceTime) {
        this.entranceTime = entranceTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(appointmentId, that.appointmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(appointmentId);
    }
}
