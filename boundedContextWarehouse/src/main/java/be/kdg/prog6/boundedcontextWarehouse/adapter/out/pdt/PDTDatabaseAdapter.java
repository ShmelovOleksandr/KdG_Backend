package be.kdg.prog6.boundedcontextWarehouse.adapter.out.pdt;

import be.kdg.prog6.boundedcontextWarehouse.adapter.out.exception.PDTNotFoundException;
import be.kdg.prog6.boundedcontextWarehouse.domain.AppointmentId;
import be.kdg.prog6.boundedcontextWarehouse.domain.PDT;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.FindPDTPort;
import be.kdg.prog6.boundedcontextWarehouse.port.out.persistance.PersistPDTPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PDTDatabaseAdapter implements PersistPDTPort, FindPDTPort {
    private final PDTJpaRepository pdtJpaRepository;

    @Autowired
    public PDTDatabaseAdapter(PDTJpaRepository pdtJpaRepository) {
        this.pdtJpaRepository = pdtJpaRepository;
    }

    @Override
    public PDT save(PDT pdt) {
        return pdtJpaRepository.save(PDTJpaEntity.of(pdt)).toDomain();
    }

    @Override
    public PDT findPDTByAppointmentId(AppointmentId appointmentId) {
        return pdtJpaRepository.findByAppointmentId(appointmentId.id()).orElseThrow(
                () -> new PDTNotFoundException("Not able to find PDT by given appointment_id [%s].".formatted(appointmentId.id()))
        ).toDomain();
    }
}
