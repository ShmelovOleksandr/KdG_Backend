package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AppointmentManagerJpaRepository extends JpaRepository<AppointmentManagerJpaEntity, LocalDate> {
}
