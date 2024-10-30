package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.dom.FacilityDetail;
import be.kdg.prog6.boundedcontextLandside.port.in.GetCurrentTruckNumberUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindAppointmentPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GetCurrentTruckNumberUseCaseImpl implements GetCurrentTruckNumberUseCase {
    private final FindAppointmentPort findAppointmentPort;

    @Autowired
    public GetCurrentTruckNumberUseCaseImpl(FindAppointmentPort findAppointmentPort) {
        this.findAppointmentPort = findAppointmentPort;
    }

    @Override
    @Transactional(readOnly = true)
    public FacilityDetail findCurrentTruckNumberInTheFacility() {
        int currentTruckNumber = findAppointmentPort.findAppointmentsWithArrivalDateNotNullAndDepartureDateNull().size();
        return new FacilityDetail(currentTruckNumber);
    }
}
