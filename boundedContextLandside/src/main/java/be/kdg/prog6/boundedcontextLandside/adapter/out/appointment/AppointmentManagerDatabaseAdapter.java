package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentManager;
import be.kdg.prog6.boundedcontextLandside.port.out.FindAppointmentManagerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AppointmentManagerDatabaseAdapter implements FindAppointmentManagerPort {
    private final AppointmentManagerJpaRepository appointmentManagerJpaRepository;
    private final HourSlotJpaRepository hourSlotJpaRepository;

    @Autowired
    public AppointmentManagerDatabaseAdapter(AppointmentManagerJpaRepository appointmentManagerJpaRepository, HourSlotJpaRepository hourSlotJpaRepository) {
        this.appointmentManagerJpaRepository = appointmentManagerJpaRepository;
        this.hourSlotJpaRepository = hourSlotJpaRepository;
    }

    @Override
    public AppointmentManager findAppointmentManagerForDate(LocalDate date) {
        AppointmentManagerJpaEntity appointmentManagerJpaEntity = appointmentManagerJpaRepository.findById(date).orElse(this.createNewAppointmentManagerForDate(date));
        return appointmentManagerJpaEntity.toDomain();
    }

    private AppointmentManagerJpaEntity createNewAppointmentManagerForDate(LocalDate date) {
        AppointmentManagerJpaEntity savedAppointmentManagerJpaEntity = appointmentManagerJpaRepository.save(new AppointmentManagerJpaEntity(date));
        AppointmentManager appointmentManager = new AppointmentManager(savedAppointmentManagerJpaEntity.getManagedDate());
        AppointmentManagerJpaEntity appointmentManagerJpaEntity = AppointmentManagerJpaEntity.of(appointmentManager);
        savedAppointmentManagerJpaEntity.setHourSlots(hourSlotJpaRepository.saveAll(appointmentManagerJpaEntity.getHourSlots()));
        return savedAppointmentManagerJpaEntity;
    }
}
