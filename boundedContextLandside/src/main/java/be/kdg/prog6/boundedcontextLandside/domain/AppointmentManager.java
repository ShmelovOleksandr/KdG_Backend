package be.kdg.prog6.boundedcontextLandside.domain;

import be.kdg.prog6.boundedcontextLandside.domain.exception.IllegalHourException;
import be.kdg.prog6.boundedcontextLandside.domain.exception.NoFreeAppointmentsSlots;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public AppointmentManager() {
    }

    public AppointmentManager(LocalDate managedDate) {
        this.managedDate = managedDate;
    }

    public AppointmentManager(LocalDate managedDate, List<HourSlot> hourSlots) {
        this.managedDate = managedDate;
        this.hourSlots = hourSlots;
    }

    public Appointment tryScheduleAppointment(SellerId sellerId, LicensePlate truckLicensePlate, MaterialType materialType, Hour prefferedHour) {
        Appointment appointment = new Appointment(
                new AppointmentId(UUID.randomUUID()),
                sellerId,
                truckLicensePlate,
                materialType,
                prefferedHour
        );

        HourSlot correspondingHourSlot = getHourSlotForHour(prefferedHour);
        if (correspondingHourSlot.hasAvailableSlots())
             return correspondingHourSlot.scheduleAnAppointment(appointment);
        else
            throw new NoFreeAppointmentsSlots("There are no free appointment slots for %s:00".formatted(prefferedHour));
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
