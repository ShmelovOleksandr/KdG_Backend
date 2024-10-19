package be.kdg.prog6.boundedcontextWarehouse.adapter.out.pdt;

import be.kdg.prog6.boundedcontextWarehouse.domain.PDT;
import be.kdg.prog6.boundedcontextWarehouse.port.out.PersistPDTPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PDTDatabaseAdapter implements PersistPDTPort {
    private final PDTJpaRepository pdtJpaRepository;

    @Autowired
    public PDTDatabaseAdapter(PDTJpaRepository pdtJpaRepository) {
        this.pdtJpaRepository = pdtJpaRepository;
    }

    @Override
    public PDT save(PDT pdt) {
        return pdtJpaRepository.save(PDTJpaEntity.of(pdt)).toDomain();
    }
}
