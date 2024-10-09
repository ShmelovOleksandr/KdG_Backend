package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.port.in.ScheduleAppointmentCommand;
import be.kdg.prog6.boundedcontextLandside.port.in.ScheduleAppointmentUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.AppointmentPersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ScheduleAppointmentUseCaseImpl implements ScheduleAppointmentUseCase {
    private final AppointmentPersistencePort appointmentPersistencePort;

    public ScheduleAppointmentUseCaseImpl(AppointmentPersistencePort appointmentPersistencePort) {
        this.appointmentPersistencePort = appointmentPersistencePort;
    }

    @Override
    public Appointment scheduleAppointment(ScheduleAppointmentCommand scheduleAppointmentCommand) {
        // create an appointment
        Appointment appointment = new Appointment(
                new AppointmentId(UUID.randomUUID()),
                scheduleAppointmentCommand.sellerId(),
                scheduleAppointmentCommand.truckLicensePlate(),
                scheduleAppointmentCommand.materialType(),
                scheduleAppointmentCommand.scheduleTime()
        );

        // save an appointment
        appointmentPersistencePort.saveAppointment(appointment);

        return appointment;
    }
}
