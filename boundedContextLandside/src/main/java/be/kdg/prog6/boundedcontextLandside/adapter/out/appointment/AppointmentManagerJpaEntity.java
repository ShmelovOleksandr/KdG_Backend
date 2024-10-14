package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentManager;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "appointment_managers")
public class AppointmentManagerJpaEntity {
    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private LocalDate managedDate;

    @OneToMany(mappedBy = "appointmentManager")
    private List<HourSlotJpaEntity> hourSlots;

    public AppointmentManagerJpaEntity() {
    }

    public AppointmentManagerJpaEntity(LocalDate managedDate) {
        this.managedDate = managedDate;
        this.hourSlots = new ArrayList<>();
    }

    public AppointmentManagerJpaEntity(LocalDate managedDate, List<HourSlotJpaEntity> hourSlots) {
        this.managedDate = managedDate;
        this.hourSlots = hourSlots;
    }

    public LocalDate getManagedDate() {
        return managedDate;
    }

    public void setManagedDate(LocalDate managedDate) {
        this.managedDate = managedDate;
    }

    public List<HourSlotJpaEntity> getHourSlots() {
        return hourSlots;
    }

    public void setHourSlots(List<HourSlotJpaEntity> hourSlots) {
        this.hourSlots = hourSlots;
    }

    public AppointmentManager toDomain() {
        return new AppointmentManager(
                this.getManagedDate(),
                this.getHourSlots().stream().map(HourSlotJpaEntity::toDomain).collect(Collectors.toList())
        );
    }

    public static AppointmentManagerJpaEntity of(AppointmentManager appointmentManager) {
        AppointmentManagerJpaEntity appointmentManagerJpaEntity = new AppointmentManagerJpaEntity(appointmentManager.getManagedDate());
        List<HourSlotJpaEntity> hourSlots = appointmentManager.getHourSlots().stream().map(HourSlotJpaEntity::of).collect(Collectors.toList());
        hourSlots.forEach(hourSlotJpaEntity -> hourSlotJpaEntity.setAppointmentManager(appointmentManagerJpaEntity));
        appointmentManagerJpaEntity.setHourSlots(hourSlots);
        return appointmentManagerJpaEntity;
    }
}
