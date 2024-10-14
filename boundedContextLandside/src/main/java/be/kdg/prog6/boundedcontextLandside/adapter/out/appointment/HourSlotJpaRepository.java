package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface HourSlotJpaRepository extends JpaRepository<HourSlotJpaEntity, HourSlotJpaEntityId> {

    @Query("select hs from HourSlotJpaEntity hs where hs.appointmentManager.managedDate = :date and hs.hour = :hour")
    Optional<HourSlotJpaEntity> findByDateAndHour(LocalDate date, int hour);
}
