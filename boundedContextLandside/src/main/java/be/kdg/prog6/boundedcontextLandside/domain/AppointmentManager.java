package be.kdg.prog6.boundedcontextLandside.domain;

import be.kdg.prog6.boundedcontextLandside.domain.exception.IllegalHourException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentManager {
    private static final int HOURS_IN_DAY = 24;

    private LocalDate managedDate;
    private List<HourSlot> hourSlots;

    {
        this.managedDate = LocalDate.now();
        this.hourSlots = new ArrayList<>();
        for (int i = 0; i < HOURS_IN_DAY; i++) {
            hourSlots.add(new HourSlot(i));
        }
    }

    public void scheduleAppointment(Appointment appointment) {
        Hour prefferedHour = appointment.prefferredHour();
        HourSlot correspondingHourSlot = getHourSlotForHour(prefferedHour);
        if (correspondingHourSlot.hasAvailableSlots())
            correspondingHourSlot.scheduleAnAppointment(appointment);

    }

    private HourSlot getHourSlotForHour(Hour hour) {
        int hourNumber = hour.hourNumber();

        if(hourNumber < 1 || hourNumber > 24)
            throw new IllegalHourException();

        return hourSlots.get(hourNumber - 1);
    }


    public LocalDate getManagedDate() {
        return managedDate;
    }

    public void setManagedDate(LocalDate managedDate) {
        this.managedDate = managedDate;
    }

    public List<HourSlot> getHourSlots() {
        return hourSlots;
    }

    public void setHourSlots(List<HourSlot> hourSlots) {
        this.hourSlots = hourSlots;
    }
}
