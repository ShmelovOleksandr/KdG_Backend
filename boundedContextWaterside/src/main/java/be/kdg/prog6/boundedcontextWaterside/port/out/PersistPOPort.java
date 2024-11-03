package be.kdg.prog6.boundedcontextWaterside.port.out;

import be.kdg.prog6.boundedcontextWaterside.domain.PO;

public interface PersistPOPort {
    PO save(PO po);
}
