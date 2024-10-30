package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.EntranceRequest;
import be.kdg.prog6.boundedcontextLandside.domain.HourSlot;
import be.kdg.prog6.boundedcontextLandside.port.in.ManageTruckArrivalUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.PersistAppointmentPort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindHourSlotPort;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageTruckArrivalUseCaseImpl implements ManageTruckArrivalUseCase {
    private final FindHourSlotPort findHourSlotPort;
    private final PersistAppointmentPort persistAppointmentPort;

    @Autowired
    public ManageTruckArrivalUseCaseImpl(FindHourSlotPort findHourSlotPort, PersistAppointmentPort persistAppointmentPort) {
        this.findHourSlotPort = findHourSlotPort;
        this.persistAppointmentPort = persistAppointmentPort;
    }

    @Override
    @Transactional
    public EntranceRequest manageEntranceRequest(EntranceRequest entranceRequest) {
        // find HourSlot
        HourSlot currentHourSlot = findHourSlotPort.findCurrentHourSlot();

        // check time and approve or disapprove
        EntranceRequest handeledEntranceRequest = currentHourSlot.checkEntranceRequest(entranceRequest);

        // update Appointment
        persistAppointmentPort.save(handeledEntranceRequest.getApprovedAppointment());

        return handeledEntranceRequest;
    }
}
