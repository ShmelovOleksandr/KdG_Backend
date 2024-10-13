package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "hour_slots")
@IdClass(HourSlotJpaEntityId.class)
public class HourSlotJpaEntity {
    @Id
    private int hour;

    @Id
    @ManyToOne(optional = false)
    private AppointmentManagerJpaEntity appointmentManager;

    @OneToMany(mappedBy = "hourSlot")
    private List<AppointmentJpaEntity> appointments;

    public HourSlotJpaEntity() {
    }

    public HourSlotJpaEntity(int hour, AppointmentManagerJpaEntity appointmentManager) {
        this.hour = hour;
        this.appointmentManager = appointmentManager;
    }

    public HourSlotJpaEntity(int hour, AppointmentManagerJpaEntity appointmentManager, List<AppointmentJpaEntity> appointments) {
        this.hour = hour;
        this.appointmentManager = appointmentManager;
        this.appointments = appointments;
    }

    public int getHour() {
        return hour;
    }

    public AppointmentManagerJpaEntity getAppointmentManager() {
        return appointmentManager;
    }

    public void setAppointmentManager(AppointmentManagerJpaEntity appointmentManagerJpa) {
        this.appointmentManager = appointmentManagerJpa;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public List<AppointmentJpaEntity> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentJpaEntity> appointments) {
        this.appointments = appointments;
    }
}
