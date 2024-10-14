package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import be.kdg.prog6.boundedcontextLandside.port.out.AppointmentPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentDatabaseAdapter implements AppointmentPersistencePort {
    private final AppointmentJpaRepository appointmentJpaRepository;

    @Autowired
    public AppointmentDatabaseAdapter(AppointmentJpaRepository appointmentJpaRepository) {
        this.appointmentJpaRepository = appointmentJpaRepository;
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        AppointmentJpaEntity appointmentJpaEntity = AppointmentJpaEntity.of(appointment);
        AppointmentJpaEntity savedAppointmentJpaEntity = appointmentJpaRepository.save(appointmentJpaEntity);
        return savedAppointmentJpaEntity.toDomain();
    }
}
