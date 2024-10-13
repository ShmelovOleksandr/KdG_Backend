package be.kdg.prog6.boundedcontextLandside.domain;

import be.kdg.prog6.boundedcontextLandside.domain.exception.NoFreeAppointmentsSlots;

import java.util.ArrayList;
import java.util.List;

public class HourSlot {
    //TODO Move to the .properties file
    private final static int MAX_APPOINTMENTS_PER_HOUR = 40;
    private int hour;
    private List<Appointment> appointments = new ArrayList<>();

    public HourSlot() {
    }

    public HourSlot(int hour) {
        this.hour = hour;
    }

    public HourSlot(int hour, List<Appointment> appointments) {
        this.hour = hour;
        this.appointments = appointments;
    }


    public boolean hasAvailableSlots() {
        return appointments.size() < MAX_APPOINTMENTS_PER_HOUR;
    }

    public Appointment scheduleAnAppointment(Appointment appointment) {
        if (!hasAvailableSlots())
            throw new NoFreeAppointmentsSlots("There are no free appointment slots for %s:00".formatted(appointment.preferredHour()));

        this.appointments.add(appointment);
        return appointment;
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
