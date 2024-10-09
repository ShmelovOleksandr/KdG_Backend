package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentJpaRepository extends JpaRepository<AppointmentJpaEntity, UUID> {
}
