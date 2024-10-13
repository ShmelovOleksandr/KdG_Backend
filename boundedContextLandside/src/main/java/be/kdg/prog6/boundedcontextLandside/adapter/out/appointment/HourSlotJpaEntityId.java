package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import java.io.Serializable;
import java.util.Objects;

public class HourSlotJpaEntityId implements Serializable {
    private int hour;
    private AppointmentManagerJpaEntity appointmentManager;

    public HourSlotJpaEntityId() {
    }

    public HourSlotJpaEntityId(int hour, AppointmentManagerJpaEntity appointmentManager) {
        this.hour = hour;
        this.appointmentManager = appointmentManager;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public AppointmentManagerJpaEntity getAppointmentManager() {
        return appointmentManager;
    }

    public void setAppointmentManager(AppointmentManagerJpaEntity appointmentManager) {
        this.appointmentManager = appointmentManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HourSlotJpaEntityId that = (HourSlotJpaEntityId) o;
        return hour == that.hour && Objects.equals(appointmentManager, that.appointmentManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, appointmentManager);
    }

    @Override
    public String toString() {
        return "HourSlotJpaEntityId{" +
                "hour=" + hour +
                ", appointmentManager=" + appointmentManager +
                '}';
    }
}
