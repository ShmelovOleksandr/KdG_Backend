package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.exception.AppointmentNotFoundException;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.AppointmentPersistencePort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindAppointmentPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentDatabaseAdapter implements AppointmentPersistencePort, FindAppointmentPort {
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

    @Override
    public Appointment findAppointmentById(AppointmentId appointmentId) {
        return appointmentJpaRepository.findById(appointmentId.id()).orElseThrow(
                () -> new AppointmentNotFoundException("Appointment with given id [%s] was not found.".formatted(appointmentId.id()))
        ).toDomain();
    }
}
