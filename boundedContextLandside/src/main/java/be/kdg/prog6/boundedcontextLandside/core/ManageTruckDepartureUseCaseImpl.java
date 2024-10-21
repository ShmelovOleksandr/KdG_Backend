package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import be.kdg.prog6.boundedcontextLandside.port.in.DepartureCommand;
import be.kdg.prog6.boundedcontextLandside.port.in.ManageTruckDepartureUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindAppointmentPort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.PersistAppointmentPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ManageTruckDepartureUseCaseImpl implements ManageTruckDepartureUseCase {
    private final FindAppointmentPort findCurrentHourSlotPort;
    private final PersistAppointmentPort persistAppointmentPort;

    @Autowired
    public ManageTruckDepartureUseCaseImpl(FindAppointmentPort findCurrentHourSlotPort, PersistAppointmentPort persistAppointmentPort) {
        this.findCurrentHourSlotPort = findCurrentHourSlotPort;
        this.persistAppointmentPort = persistAppointmentPort;
    }

    @Override
    public void manageDepartureRequest(DepartureCommand departureCommand) {
        Appointment appointment = findCurrentHourSlotPort.findAppointmentById(departureCommand.appointmentId());

        appointment.setDepartureTime(LocalDateTime.now());

        persistAppointmentPort.save(appointment);
    }
}
