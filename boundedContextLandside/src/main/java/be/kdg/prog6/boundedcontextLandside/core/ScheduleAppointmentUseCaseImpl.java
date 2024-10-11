package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.domain.AppointmentManager;
import be.kdg.prog6.boundedcontextLandside.port.in.ScheduleAppointmentCommand;
import be.kdg.prog6.boundedcontextLandside.port.in.ScheduleAppointmentUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.AppointmentPersistencePort;
import be.kdg.prog6.boundedcontextLandside.port.out.FindAppointmentManagerPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ScheduleAppointmentUseCaseImpl implements ScheduleAppointmentUseCase {
    private final AppointmentPersistencePort appointmentPersistencePort;
    private final FindAppointmentManagerPort findAppointmentManagerPort;

    public ScheduleAppointmentUseCaseImpl(AppointmentPersistencePort appointmentPersistencePort, FindAppointmentManagerPort findAppointmentManagerPort) {
        this.appointmentPersistencePort = appointmentPersistencePort;
        this.findAppointmentManagerPort = findAppointmentManagerPort;
    }

    @Override
    @Transactional
    public Appointment scheduleAppointment(ScheduleAppointmentCommand scheduleAppointmentCommand) {
        // create an appointment
        Appointment appointment = new Appointment(
                new AppointmentId(UUID.randomUUID()),
                scheduleAppointmentCommand.sellerId(),
                scheduleAppointmentCommand.truckLicensePlate(),
                scheduleAppointmentCommand.materialType(),
                scheduleAppointmentCommand.prefferedHour()
        );

        //checks (in the domain class) (2 rules)

        // save an appointment
        appointmentPersistencePort.saveAppointment(appointment);

        return appointment;
    }
}
