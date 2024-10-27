package be.kdg.prog6.boundedcontextWaterside.adapter.out.po;

import be.kdg.prog6.boundedcontextWaterside.adapter.out.exception.PONotFoundException;
import be.kdg.prog6.boundedcontextWaterside.domain.PO;
import be.kdg.prog6.boundedcontextWaterside.domain.POId;
import be.kdg.prog6.boundedcontextWaterside.port.out.FindPOPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PODatabaseAdapter implements FindPOPort {
    private final POJpaRepository poJpaRepository;

    @Autowired
    public PODatabaseAdapter(POJpaRepository poJpaRepository) {
        this.poJpaRepository = poJpaRepository;
    }

    @Override
    public PO findPOById(POId poId) {
        return poJpaRepository.findById(poId.id()).orElseThrow(
                () -> new PONotFoundException("PO with given id [%s] not found.".formatted(poId.id()))
        ).toDomain();
    }
}
