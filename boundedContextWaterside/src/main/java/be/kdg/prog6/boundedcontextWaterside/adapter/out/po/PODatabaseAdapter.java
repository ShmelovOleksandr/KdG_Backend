package be.kdg.prog6.boundedcontextWaterside.adapter.out.po;

import be.kdg.prog6.boundedcontextWaterside.adapter.out.exception.PONotFoundException;
import be.kdg.prog6.boundedcontextWaterside.domain.PO;
import be.kdg.prog6.boundedcontextWaterside.domain.POId;
import be.kdg.prog6.boundedcontextWaterside.port.out.FindPOPort;
import be.kdg.prog6.boundedcontextWaterside.port.out.PersistPOPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PODatabaseAdapter implements FindPOPort, PersistPOPort {
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

    @Override
    public List<PO> findAllFulfilledPOs() {
        return poJpaRepository.findAllBySoNotNull().stream().map(POJpaEntity::toDomain).toList();
    }

    @Override
    public List<PO> findAllOutstandingPOs() {
        return poJpaRepository.findAllBySoNull().stream().map(POJpaEntity::toDomain).toList();
    }

    @Override
    public PO save(PO po) {
        return poJpaRepository.save(POJpaEntity.of(po)).toDomain();
    }
}
