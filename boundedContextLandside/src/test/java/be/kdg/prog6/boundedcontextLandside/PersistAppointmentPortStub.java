package be.kdg.prog6.boundedcontextLandside;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.PersistAppointmentPort;

public class PersistAppointmentPortStub implements PersistAppointmentPort {
    private Appointment appointment;

    @Override
    public Appointment save(Appointment appointment) {
        return this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }
}
