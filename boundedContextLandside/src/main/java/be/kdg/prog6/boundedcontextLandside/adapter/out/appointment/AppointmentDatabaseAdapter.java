package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import be.kdg.prog6.boundedcontextLandside.port.out.AppointmentPersistencePort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AppointmentDatabaseAdapter implements AppointmentPersistencePort {
    private final ModelMapper mapper;
    private final AppointmentJpaRepository appointmentJpaRepository;

    public AppointmentDatabaseAdapter(ModelMapper mapper, AppointmentJpaRepository appointmentJpaRepository) {
        this.mapper = mapper;
        this.appointmentJpaRepository = appointmentJpaRepository;
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        AppointmentJpaEntity appointmentJpaEntity = mapper.map(appointment, AppointmentJpaEntity.class);
        AppointmentJpaEntity savedAppointmentJpaEntity = appointmentJpaRepository.save(appointmentJpaEntity);
        return mapper.map(savedAppointmentJpaEntity, Appointment.class);
    }
}
