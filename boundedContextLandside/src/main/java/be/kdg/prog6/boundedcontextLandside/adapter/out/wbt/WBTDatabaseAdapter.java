package be.kdg.prog6.boundedcontextLandside.adapter.out.wbt;

import be.kdg.prog6.boundedcontextLandside.adapter.out.exception.WBTNotFoundException;
import be.kdg.prog6.boundedcontextLandside.domain.AppointmentId;
import be.kdg.prog6.boundedcontextLandside.domain.WBT;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.FindWBTPort;
import be.kdg.prog6.boundedcontextLandside.port.out.persistance.PersistWBTPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WBTDatabaseAdapter implements PersistWBTPort, FindWBTPort {
    private final WBTJpaRepository wbtJpaRepository;

    @Autowired
    public WBTDatabaseAdapter(WBTJpaRepository wbtJpaRepository) {
        this.wbtJpaRepository = wbtJpaRepository;
    }

    @Override
    public WBT save(WBT wbt) {
        return wbtJpaRepository.save(WBTJpaEntity.of(wbt)).toDomain();
    }

    @Override
    public WBT findWBTByAppointmentId(AppointmentId appointmentId) {
        return wbtJpaRepository.findByAppointment_Id(appointmentId.id()).orElseThrow(
                () -> new WBTNotFoundException("WBT with given appointmentId [%s] not found.".formatted(appointmentId.id()))
        ).toDomain();
    }
}
