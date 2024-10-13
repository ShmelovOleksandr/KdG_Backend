package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}
