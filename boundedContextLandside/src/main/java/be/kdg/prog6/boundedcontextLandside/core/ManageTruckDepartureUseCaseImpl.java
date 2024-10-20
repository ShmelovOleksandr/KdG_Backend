package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.port.in.DepartureCommand;
import be.kdg.prog6.boundedcontextLandside.port.in.ManageTruckDepartureUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindCurrentHourSlotPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageTruckDepartureUseCaseImpl implements ManageTruckDepartureUseCase {
    private final FindCurrentHourSlotPort findCurrentHourSlotPort;

    @Autowired
    public ManageTruckDepartureUseCaseImpl(FindCurrentHourSlotPort findCurrentHourSlotPort) {
        this.findCurrentHourSlotPort = findCurrentHourSlotPort;
    }

    @Override
    public void manageDepartureRequest(DepartureCommand departureCommand) {
        // TODO
    }
}
