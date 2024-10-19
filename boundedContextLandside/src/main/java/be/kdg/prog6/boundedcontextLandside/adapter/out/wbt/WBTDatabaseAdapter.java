package be.kdg.prog6.boundedcontextLandside.adapter.out.wbt;

import be.kdg.prog6.boundedcontextLandside.domain.WBT;
import be.kdg.prog6.boundedcontextLandside.port.out.PersistWBTPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WBTDatabaseAdapter implements PersistWBTPort {
    private final WBTJpaRepository wbtJpaRepository;

    @Autowired
    public WBTDatabaseAdapter(WBTJpaRepository wbtJpaRepository) {
        this.wbtJpaRepository = wbtJpaRepository;
    }

    @Override
    public WBT save(WBT wbt) {
        return wbtJpaRepository.save(WBTJpaEntity.of(wbt)).toDomain();
    }
}
