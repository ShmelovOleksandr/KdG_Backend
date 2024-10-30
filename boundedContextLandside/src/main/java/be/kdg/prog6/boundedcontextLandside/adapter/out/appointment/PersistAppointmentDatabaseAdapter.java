package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import be.kdg.prog6.boundedcontextLandside.domain.Appointment;
import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.adapter.out.appointment.exception.AppointmentNotFoundException;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.PersistAppointmentPort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindAppointmentPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersistAppointmentDatabaseAdapter implements PersistAppointmentPort, FindAppointmentPort {
    private final AppointmentJpaRepository appointmentJpaRepository;

    @Autowired
    public PersistAppointmentDatabaseAdapter(AppointmentJpaRepository appointmentJpaRepository) {
        this.appointmentJpaRepository = appointmentJpaRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
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

    @Override
    public List<Appointment> findAppointmentsWithArrivalDateNotNullAndDepartureDateNull() {
        return appointmentJpaRepository.findAllByEntranceTimeIsNotNullAndDepartureTimeIsNull().stream().map(AppointmentJpaEntity::toDomain).toList();
    }
}
