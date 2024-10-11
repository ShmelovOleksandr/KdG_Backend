package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface HourSlotJpaRepository extends JpaRepository<HourSlotJpaEntity, LocalDate> {
}
