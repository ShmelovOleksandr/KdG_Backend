package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import be.kdg.prog6.boundedcontextLandside.domain.Hour;
import be.kdg.prog6.boundedcontextLandside.domain.HourSlot;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindHourSlotPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class HourSlotDatabaseAdapter implements FindHourSlotPort {
    private final HourSlotJpaRepository hourSlotJpaRepository;

    @Autowired
    public HourSlotDatabaseAdapter(HourSlotJpaRepository hourSlotJpaRepository) {
        this.hourSlotJpaRepository = hourSlotJpaRepository;
    }

    @Override
    public HourSlot findCurrentHourSlot() {
        LocalDateTime now = LocalDateTime.now();
        return this.findHourSlotByDateAndHour(now.toLocalDate(), new Hour(now.getHour()));
    }

    @Override
    public HourSlot findHourSlotByDateAndHour(LocalDate date, Hour hour) {
        return hourSlotJpaRepository.findByDateAndHour(date, hour.hourNumber()).orElseThrow(
                () -> new EntityNotFoundException("Hour slot for %s at %s not found.".formatted(date.toString(), hour.hourNumber()))
        ).toDomain();
    }
}
