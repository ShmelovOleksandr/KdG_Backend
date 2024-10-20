package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.EntranceRequest;
import be.kdg.prog6.boundedcontextLandside.domain.HourSlot;
import be.kdg.prog6.boundedcontextLandside.port.in.ManageTruckArrivalUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.AppointmentPersistencePort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindCurrentHourSlotPort;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageTruckArrivalUseCaseImpl implements ManageTruckArrivalUseCase {
    private final FindCurrentHourSlotPort findCurrentHourSlotPort;
    private final AppointmentPersistencePort appointmentPersistencePort;

    @Autowired
    public ManageTruckArrivalUseCaseImpl(FindCurrentHourSlotPort findCurrentHourSlotPort, AppointmentPersistencePort appointmentPersistencePort) {
        this.findCurrentHourSlotPort = findCurrentHourSlotPort;
        this.appointmentPersistencePort = appointmentPersistencePort;
    }

    @Override
    @Transactional
    public EntranceRequest manageEntranceRequest(EntranceRequest entranceRequest) {
        // find HourSlot
        HourSlot currentHourSlot = findCurrentHourSlotPort.findCurrentHourSlot();

        // check time and approve or disapprove
        EntranceRequest handeledEntranceRequest = currentHourSlot.checkEntranceRequest(entranceRequest);

        // update Appointment
        appointmentPersistencePort.saveAppointment(handeledEntranceRequest.getApprovedAppointment());

        return handeledEntranceRequest;
    }
}
