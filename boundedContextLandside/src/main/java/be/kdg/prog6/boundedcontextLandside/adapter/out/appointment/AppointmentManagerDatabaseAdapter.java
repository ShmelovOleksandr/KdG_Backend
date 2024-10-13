package be.kdg.prog6.boundedcontextLandside.adapter.out.appointment;

import be.kdg.prog6.boundedcontextLandside.domain.AppointmentManager;
import be.kdg.prog6.boundedcontextLandside.domain.HourSlot;
import be.kdg.prog6.boundedcontextLandside.port.out.FindAppointmentManagerPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AppointmentManagerDatabaseAdapter implements FindAppointmentManagerPort {
    private final ModelMapper mapper;
    private final AppointmentManagerJpaRepository appointmentManagerJpaRepository;
    private final HourSlotJpaRepository hourSlotJpaRepository;

    @Autowired
    public AppointmentManagerDatabaseAdapter(ModelMapper mapper, AppointmentManagerJpaRepository appointmentManagerJpaRepository, HourSlotJpaRepository hourSlotJpaRepository) {
        this.mapper = mapper;
        this.appointmentManagerJpaRepository = appointmentManagerJpaRepository;
        this.hourSlotJpaRepository = hourSlotJpaRepository;
    }

    @Override
    public AppointmentManager findAppointmentManagerForCurrentDay() {
        AppointmentManagerJpaEntity appointmentManagerJpaEntity = appointmentManagerJpaRepository.findById(LocalDate.now()).orElse(this.createNewAppointmentManager());
        return mapper.map(appointmentManagerJpaEntity, AppointmentManager.class);
    }

    private AppointmentManagerJpaEntity createNewAppointmentManager() {
        AppointmentManager appointmentManager = new AppointmentManager();
        AppointmentManagerJpaEntity appointmentManagerJpaEntity = mapper.map(appointmentManager, AppointmentManagerJpaEntity.class);
        AppointmentManagerJpaEntity savedAppointmentManagerJpaEntity = appointmentManagerJpaRepository.save(appointmentManagerJpaEntity);
        hourSlotJpaRepository.saveAll(appointmentManagerJpaEntity.getHourSlots());
        return savedAppointmentManagerJpaEntity;
    }
}
