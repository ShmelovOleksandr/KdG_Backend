package be.kdg.prog6.boundedcontextLandside.domain;

import be.kdg.prog6.boundedcontextLandside.domain.exception.AppointmentForGivenLicensePlateNotFoundException;
import be.kdg.prog6.boundedcontextLandside.domain.exception.NoFreeAppointmentsSlots;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HourSlot {
    //TODO Move to the .properties file
    private final static int MAX_APPOINTMENTS_PER_HOUR = 40;
    private LocalDate date;
    private int hour;
    private List<Appointment> appointments = new ArrayList<>();

    public HourSlot() {
    }

    public HourSlot(int hour) {
        this.hour = hour;
    }

    public HourSlot(LocalDate date, int hour, List<Appointment> appointments) {
        this.date = date;
        this.hour = hour;
        this.appointments = appointments;
    }


    public boolean hasAvailableSlots() {
        return appointments.size() < MAX_APPOINTMENTS_PER_HOUR;
    }

    public Appointment scheduleAnAppointment(Appointment appointment) {
        if (!hasAvailableSlots())
            throw new NoFreeAppointmentsSlots("There are no free appointment slots for %s:00".formatted(appointment.getArrivalHour()));

        this.appointments.add(appointment);
        return appointment;
    }

    public EntranceRequest checkEntranceRequest(EntranceRequest entranceRequest) {
        LicensePlate licensePlate = entranceRequest.getLicensePlate();
        MaterialType materialType = entranceRequest.getMaterialType();
        Predicate<Appointment> appointmentPredicate = appointment -> {
            boolean isLicensePlateSimilar = appointment.getLicensePlate().equals(licensePlate);
            boolean isMaterialTypeSimilar = appointment.getMaterialType() == materialType;
            boolean isNotFulfilled = appointment.getDepartureTime() == null;
            return isLicensePlateSimilar && isMaterialTypeSimilar && isNotFulfilled;
        };

        Appointment correspondingAppointment = appointments.stream()
                .filter(appointmentPredicate)
                .sorted()
                .findFirst()
                .orElseThrow(
                        () -> new AppointmentForGivenLicensePlateNotFoundException("Appointment with license plate [%s] and material type [%s] not found".formatted(licensePlate, materialType))
                );

        correspondingAppointment.setEntranceTime(LocalDateTime.now());
        entranceRequest.setApproved(true);
        entranceRequest.setApprovedAppointment(correspondingAppointment);

        return entranceRequest;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
