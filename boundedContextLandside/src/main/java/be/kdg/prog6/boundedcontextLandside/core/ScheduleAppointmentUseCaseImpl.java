package be.kdg.prog6.boundedcontextLandside.core;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import be.kdg.prog6.boundedcontextLandside.domain.AppointmentManager;
import be.kdg.prog6.boundedcontextLandside.port.in.ScheduleAppointmentCommand;
import be.kdg.prog6.boundedcontextLandside.port.in.ScheduleAppointmentUseCase;
import be.kdg.prog6.boundedcontextLandside.port.out.AppointmentPersistencePort;
import be.kdg.prog6.boundedcontextLandside.port.out.FindAppointmentManagerPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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


        AppointmentManager currentAppointmentManager = findAppointmentManagerPort.findAppointmentManagerForDate(scheduleAppointmentCommand.date());

        //checks (in the domain class) (2 rules)
        Appointment savedAppointment = currentAppointmentManager.tryScheduleAppointment(
                scheduleAppointmentCommand.sellerId(),
                scheduleAppointmentCommand.truckLicensePlate(),
                scheduleAppointmentCommand.materialType(),
                scheduleAppointmentCommand.date(),
                scheduleAppointmentCommand.prefferedHour()
        );

        // save an appointment
        appointmentPersistencePort.saveAppointment(savedAppointment);

        return savedAppointment;
    }
}
