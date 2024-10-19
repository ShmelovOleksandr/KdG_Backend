package be.kdg.prog6.boundedcontextLandside.port.out;

import be.kdg.prog6.boundedcontextLandside.domain.WBT;

public interface PersistWBTPort {
    WBT save(WBT wbt);
}
