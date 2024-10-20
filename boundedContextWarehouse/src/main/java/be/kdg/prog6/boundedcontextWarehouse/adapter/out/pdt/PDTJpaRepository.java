package be.kdg.prog6.boundedcontextWarehouse.adapter.out.pdt;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PDTJpaRepository extends JpaRepository<PDTJpaEntity, UUID> {
    Optional<PDTJpaEntity> findByAppointmentId(UUID appointmentId);
}
