package be.kdg.prog6.boundedcontextLandside.domain;

import java.util.List;

public class HourSlot {
    //TODO Move to the .properties file
    private final static int MAX_APPOINTMENTS_PER_HOUR = 40;
    private int hour;
    private List<Appointment> appointments;

    public HourSlot(int hour) {
        this.hour = hour;
    }

    public boolean hasAvailableSlots() {
        return appointments.size() < MAX_APPOINTMENTS_PER_HOUR;
    }

    public void scheduleAnAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
}
