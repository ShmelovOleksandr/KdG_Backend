package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.Hour;
import be.kdg.prog6.boundedcontextLandside.domain.HourSlot;
import be.kdg.prog6.boundedcontextLandside.port.in.GetHourSlotDetailsUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindHourSlotPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class GetHourSlotDetailsUseCaseImpl implements GetHourSlotDetailsUseCase {
    private final FindHourSlotPort findHourSlotPort;

    @Autowired
    public GetHourSlotDetailsUseCaseImpl(FindHourSlotPort findHourSlotPort) {
        this.findHourSlotPort = findHourSlotPort;
    }

    @Override
    @Transactional
    public HourSlot getHourSlotDetailsForDateAndHour(LocalDate date, Hour hour) {
        return findHourSlotPort.findHourSlotByDateAndHour(date, hour);
    }
}
