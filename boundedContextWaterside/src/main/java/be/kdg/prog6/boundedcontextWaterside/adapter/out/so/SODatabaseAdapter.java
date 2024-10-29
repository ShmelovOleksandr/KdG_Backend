package be.kdg.prog6.boundedcontextWaterside.adapter.out.so;

import be.kdg.prog6.boundedcontextWaterside.adapter.out.exception.SONotFoundException;
import be.kdg.prog6.boundedcontextWaterside.domain.SO;
import be.kdg.prog6.boundedcontextWaterside.domain.SOId;
import be.kdg.prog6.boundedcontextWaterside.port.out.FindSOPort;
import be.kdg.prog6.boundedcontextWaterside.port.out.PersistSOPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SODatabaseAdapter implements PersistSOPort, FindSOPort {
    private final SOJpaRepository soJpaRepository;

    @Autowired
    public SODatabaseAdapter(SOJpaRepository soJpaRepository) {
        this.soJpaRepository = soJpaRepository;
    }

    @Override
    public SO save(SO so) {
        return soJpaRepository.save(SOJpaEntity.of(so)).toDomain();
    }

    @Override
    public SO findSOById(SOId soId) {
        return soJpaRepository.findById(soId.id()).orElseThrow(
                () -> new SONotFoundException("SO with given id [%s] not found.".formatted(soId.id()))
        ).toDomain();
    }
}
