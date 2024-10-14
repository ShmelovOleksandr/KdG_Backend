package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import be.kdg.prog6.boundedcontextLandside.domain.HourSlot;
import be.kdg.prog6.boundedcontextLandside.port.out.FindCurrentHourSlotPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class HourSlotDatabaseAdapter implements FindCurrentHourSlotPort {
    private final HourSlotJpaRepository hourSlotJpaRepository;

    @Autowired
    public HourSlotDatabaseAdapter(HourSlotJpaRepository hourSlotJpaRepository) {
        this.hourSlotJpaRepository = hourSlotJpaRepository;
    }

    @Override
    public HourSlot findCurrentHourSlot() {
        LocalDateTime now = LocalDateTime.now();
        HourSlotJpaEntity hourSlotJpaEntity = hourSlotJpaRepository.findByDateAndHour(now.toLocalDate(), now.getHour()).orElseThrow(
                () -> new EntityNotFoundException("Hour slot for %s not found.".formatted(now.toString()))
        );
        return hourSlotJpaEntity.toDomain();
    }
}
